package com.yonyougov.controller;

import com.github.pagehelper.PageInfo;
import com.yonyougov.common.domain.BalanceQueryDTO;
import com.yonyougov.common.elasticsearch.ElasticSearchUtil;
import com.yonyougov.entity.Balance;
import com.yonyougov.service.BalanceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.elasticsearch.core.aggregation.AggregatedPage;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author kongdezhi
 */
@RestController
@RequestMapping("balance")
@Api(tags = "1.1", value = "额度管理")
public class BalanceController {

    private BalanceService balanceService;

    private ElasticSearchUtil elasticSearchUtil;


    public BalanceController(BalanceService balanceService, ElasticSearchUtil elasticSearchUtil) {
        this.balanceService = balanceService;
        this.elasticSearchUtil = elasticSearchUtil;
    }

    /**
     * 为Balance建立索引
     *
     * @return 是否成功建立
     */
    @GetMapping("/index")
    @ApiOperation(value = "Balance建立索引",httpMethod = "GET")
    public boolean createBalanceIndex() {
        return elasticSearchUtil.createIndex(Balance.class);
    }

    /**
     * 根据id索引一个额度文档到额度索引中
     *
     * @param id 额度id
     * @return 索引文档
     */
    @GetMapping("/{id}")
    public Balance synchronizeBalanceById(@PathVariable Long id) {
        Balance balance = balanceService.queryById(id);
        try {
            balance = elasticSearchUtil.save(balance);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return balance;
    }

    /**
     * 分页查询同步额度
     *
     * @param pageNum  当前页
     * @param pageSize 每页显示条数
     * @return 查询结果
     */
    @GetMapping("/{pageNum}/{pageSize}")
    public PageInfo<Balance> queryAllByLimit(@PathVariable Integer pageNum, @PathVariable Integer pageSize) {
        PageInfo<Balance> pageInfo = balanceService.queryAllByLimit(pageNum, pageSize);
        List<Balance> list = pageInfo.getList();
        try {
            elasticSearchUtil.save(list);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pageInfo;
    }

    /**
     * 额度表关联ccids查询并同步数据至ES
     *
     * @return 查询结果
     */
    @GetMapping("/balanceRelatedCcids")
    @ApiOperation(value = "额度表关联ccids查询并同步数据至ES",httpMethod = "GET")
    public List<Balance> queryAllByRelatedCcids() {
        List<Balance> balances = balanceService.queryAllByRelatedCcids();
        try {
            elasticSearchUtil.save(balances);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return balances;
    }

    /**
     * 从ES中进行额度条件词查询
     *
     * @param balanceQueryDTO 额度查询条件封装类
     * @return 查询结果
     */
    @PostMapping("/querySpecifiedFieldByConditionWord")
    @ApiOperation(value = "从ES中进行额度条件词查询",httpMethod = "POST")
    public AggregatedPage<Balance> querySpecifiedFieldByConditionWord(@RequestBody BalanceQueryDTO balanceQueryDTO) {
        return balanceService.querySpecifiedFieldByConditionWord(balanceQueryDTO);
    }

    /**
     * 对条件查询结果对指定金额字段进行统计求和(支持对多字段求和)
     *
     * @param balanceQueryDTO 条件封装实体
     */
    @PostMapping("/statisticalSummationByCondition")
    @ApiOperation(value = "对条件查询结果对指定金额字段进行统计求和(支持对多字段求和)",httpMethod = "POST")
    public Map statisticalSummationByCondition(@RequestBody BalanceQueryDTO balanceQueryDTO) {
        return balanceService.statisticalSummationByCondition(balanceQueryDTO);
    }

    /**
     * 对条件查询结果和分组进行指定金额字段进行统计求和(支持对多字段求和)
     *
     * @param balanceQueryDTO 条件封装实体
     */
    @PostMapping("/statisticalSummationByConditionGroup")
    @ApiOperation(value = "对条件查询结果和分组进行指定金额字段进行统计求和(支持对多字段求和)",httpMethod = "POST")
    public Map statisticalSummationByConditionGroup(@RequestBody BalanceQueryDTO balanceQueryDTO) {
        return balanceService.statisticalSummationByConditionGroup(balanceQueryDTO);
    }

}
