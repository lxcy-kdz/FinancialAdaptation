package com.yonyougov.service.impl;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yonyougov.common.domain.BalanceQueryDTO;
import com.yonyougov.common.elasticsearch.ElasticSearchUtil;
import com.yonyougov.entity.Balance;
import com.yonyougov.mapper.BalanceMapper;
import com.yonyougov.service.BalanceService;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.RangeQueryBuilder;
import org.elasticsearch.search.aggregations.Aggregation;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.bucket.terms.Terms;
import org.elasticsearch.search.aggregations.bucket.terms.TermsAggregationBuilder;
import org.elasticsearch.search.aggregations.metrics.sum.InternalSum;
import org.elasticsearch.search.aggregations.metrics.sum.SumAggregationBuilder;
import org.elasticsearch.search.sort.SortBuilder;
import org.elasticsearch.search.sort.SortBuilders;
import org.elasticsearch.search.sort.SortOrder;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.aggregation.AggregatedPage;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 额度逻辑处理层实现类
 *
 * @author kongdezhi
 */
@Service
public class BalanceServiceImpl implements BalanceService {

    private BalanceMapper balanceMapper;


    private ElasticSearchUtil elasticSearchUtil;

    public BalanceServiceImpl(BalanceMapper balanceMapper, ElasticSearchUtil elasticSearchUtil) {
        this.balanceMapper = balanceMapper;
        this.elasticSearchUtil = elasticSearchUtil;
    }

    @Override
    public PageInfo<Balance> queryAllByLimit(Integer pageNum, Integer pageSize) {
        return PageHelper.startPage(pageNum, pageSize).
                doSelectPageInfo(() -> balanceMapper.queryAll());
    }

    @Override
    public Balance queryById(long id) {
        return balanceMapper.queryById(id);
    }

    @Override
    public List<Balance> queryAll() {
        return balanceMapper.queryAll();
    }

    @Override
    public List<Balance> queryAllByRelatedCcids() {
        return balanceMapper.queryAllByRelatedCcids();
    }

    @Override
    public AggregatedPage<Balance> querySpecifiedFieldByConditionWord(BalanceQueryDTO balanceQueryDTO) {
        //拼接查询条件
        BoolQueryBuilder queryBuilder = getBoolQueryBuilder(balanceQueryDTO);
        NativeSearchQueryBuilder nativeSearchQueryBuilder = new NativeSearchQueryBuilder()
                .withQuery(queryBuilder);
        if (balanceQueryDTO.getPageNum() != null && balanceQueryDTO.getPageSize() != null) {
            nativeSearchQueryBuilder.withPageable(PageRequest.of(balanceQueryDTO.getPageNum(), balanceQueryDTO.getPageSize()));
        }
        //添加排序
        Map<String, SortOrder> sortCondition = balanceQueryDTO.getSortCondition();
        if (sortCondition != null && sortCondition.size() > 0) {
            sortCondition.forEach((key, value) -> {
                SortBuilder sortBuilder = SortBuilders.fieldSort(key).order(value);
                nativeSearchQueryBuilder.withSort(sortBuilder);
            });
        }
        if (balanceQueryDTO.getReturnField() != null && balanceQueryDTO.getReturnField().length > 0) {
            nativeSearchQueryBuilder.withFields(balanceQueryDTO.getReturnField());
        }
        SimpleDateFormat f = new SimpleDateFormat("日期是 " + "yyyy 年 MM 月 dd 日 E HH 点 mm 分 ss 秒 SSS 毫秒");
        AggregatedPage<Balance> balances = elasticSearchUtil.getElasticsearchTemplate().queryForPage(nativeSearchQueryBuilder.build(), Balance.class);
        List<Balance> content = balances.getContent();
        for (Balance balance : content) {
            Date lastModifiedDate = balance.getLastModifiedDate();
            String format = f.format(lastModifiedDate);
            System.out.println(format);
        }
        return balances;
    }

    @Override
    public Map statisticalSummationByCondition(BalanceQueryDTO balanceQueryDTO) {
        //拼接过滤条件sumFields
        BoolQueryBuilder queryBuilder = getBoolQueryBuilder(balanceQueryDTO);
        //定义求和项
        NativeSearchQueryBuilder nativeSearchQueryBuilder = new NativeSearchQueryBuilder()
                .withQuery(queryBuilder);
        String[] sumFields = balanceQueryDTO.getSumFields();
        if (sumFields != null && sumFields.length > 0) {
            for (String sumField : sumFields) {
                nativeSearchQueryBuilder.addAggregation(AggregationBuilders.sum(sumField).field(sumField));
            }
        }
        Map statisticsResultMap = elasticSearchUtil.getElasticsearchTemplate().query(nativeSearchQueryBuilder.build(), response -> {
            Map resultMap = new HashMap();
            List<Aggregation> aggregations = response.getAggregations().asList();
            aggregations.forEach(aggregation -> {
                InternalSum sum = (InternalSum) aggregation;
                resultMap.put(sum.getName(), new BigDecimal(formatFloatNumber(sum.getValue())));
            });
            return resultMap;
        });
        return statisticsResultMap;
    }

    @Override
    public Map statisticalSummationByConditionGroup(BalanceQueryDTO balanceQueryDTO) {
        //拼接过滤条件
        BoolQueryBuilder queryBuilder = getBoolQueryBuilder(balanceQueryDTO);
        //定义求和项
        TermsAggregationBuilder groupBuilder = AggregationBuilders.terms(balanceQueryDTO.getGroupField()).field(balanceQueryDTO.getGroupField());
        String[] sumFields = balanceQueryDTO.getSumFields();
        TermsAggregationBuilder termsAggregationBuilder = null;
        if (sumFields != null && sumFields.length > 0) {
            for (String sumField : sumFields) {
                groupBuilder.subAggregation(AggregationBuilders.sum(sumField).field(sumField));
            }
        }
        SearchQuery searchQuery = new NativeSearchQueryBuilder()
                .withQuery(queryBuilder)
                .addAggregation(termsAggregationBuilder)
                .build();
        HashMap statisticsResultMap = elasticSearchUtil.getElasticsearchTemplate().query(searchQuery, response -> {
            Terms company_count = response.getAggregations().get(balanceQueryDTO.getGroupField());
            HashMap resultMap = new HashMap();
            for (Terms.Bucket entry : company_count.getBuckets()) {
                String key = entry.getKeyAsString();
                long docCount = entry.getDocCount();
                Map sumResultMap = new HashMap();
                for (String sumField : sumFields) {
                    double avg_salary = ((InternalSum) entry.getAggregations().get(sumField)).getValue();
                    sumResultMap.put(sumField, new BigDecimal(formatFloatNumber(avg_salary)));
                }
                resultMap.put(key, sumResultMap);
            }
            return resultMap;
        });
        return statisticsResultMap;
    }

    private BoolQueryBuilder getBoolQueryBuilder(BalanceQueryDTO balanceQueryDTO) {
        String[] fetchFields = balanceQueryDTO.getFetchField();
        Map<String, String> andConditionMap = balanceQueryDTO.getAndConditionMap();
        BoolQueryBuilder queryBuilder = QueryBuilders.boolQuery();
        //定义存放and与条件QueryBuilder
        BoolQueryBuilder andQueryBuilder = QueryBuilders.boolQuery();
        //组装and条件QueryBuilder
        if (andConditionMap != null && andConditionMap.size() > 0) {
            andConditionMap.forEach((key, value) -> {
                QueryBuilder termQueryBuilder = QueryBuilders.termQuery(key, value);
                andQueryBuilder.must(termQueryBuilder);
            });
        }
        //模拟权限查询
        Map<String, String[]> permissionCondition = balanceQueryDTO.getPermissionCondition();
        if (permissionCondition != null && permissionCondition.size() > 0) {
            permissionCondition.forEach((key, value) -> {
                QueryBuilder termQueryBuilder = QueryBuilders.termsQuery(key, value);
                andQueryBuilder.must(termQueryBuilder);
            });
        }
        //指定字段进行单字符串模糊查询
        BoolQueryBuilder likeQueryBuilder = QueryBuilders.boolQuery();
        if (fetchFields != null && fetchFields.length > 0) {
            for (String fetchField : fetchFields) {
                QueryBuilder wildcardQueryBuilder = QueryBuilders.wildcardQuery(fetchField, "*" + balanceQueryDTO.getConditionWord() + "*");
                likeQueryBuilder.should(wildcardQueryBuilder);
            }
        }
        //对指定金额字段进行范围查询
        Map<String, String[]> moneyRange = balanceQueryDTO.getMoneyRange();
        if (moneyRange != null) {
            moneyRange.forEach((key, value) -> {
                RangeQueryBuilder lte = QueryBuilders.rangeQuery(key).gte(value[0]).lte(value[1]);
                queryBuilder.must(lte);
            });
        }
        queryBuilder.must(andQueryBuilder).must(likeQueryBuilder);
        return queryBuilder;
    }

    public String formatFloatNumber(Double value) {
        if (value != null) {
            if (value.doubleValue() != 0.00) {
                java.text.DecimalFormat df = new java.text.DecimalFormat("########.00");
                return df.format(value.doubleValue());
            } else {
                return "0.00";
            }
        }
        return "";
    }

    /**
     * 判断一个字符串是否是数字类型
     *
     * @param str 字符串
     * @return 判定结果
     */
    private static boolean isNumber(String str) {
        String reg = "^[0-9]+(.[0-9]+)?$";
        return str.matches(reg);
    }
}
