package com.yonyougov.service.impl;

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
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.aggregation.AggregatedPage;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.stereotype.Service;

import java.util.List;

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
        String[] fetchFields = balanceQueryDTO.getFetchField();
        BoolQueryBuilder queryBuilder = QueryBuilders.boolQuery();
        for (String fetchField : fetchFields) {
            QueryBuilder termsQueryBuilder = QueryBuilders.wildcardQuery(fetchField, "*" + balanceQueryDTO.getConditionWord() + "*");
            queryBuilder.should(termsQueryBuilder);
        }
        NativeSearchQuery nativeSearchQuery = new NativeSearchQueryBuilder()
                .withQuery(queryBuilder)
                .withPageable(PageRequest.of(0, 10))
                .withFields(balanceQueryDTO.getReturnField())
                .build();
        return elasticSearchUtil.getElasticsearchTemplate().queryForPage(nativeSearchQuery, Balance.class);
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
