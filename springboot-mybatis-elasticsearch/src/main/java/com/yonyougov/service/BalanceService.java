package com.yonyougov.service;

import com.github.pagehelper.PageInfo;
import com.yonyougov.common.domain.BalanceQueryDTO;
import com.yonyougov.entity.Balance;
import org.springframework.data.elasticsearch.core.aggregation.AggregatedPage;

import java.util.List;

/**
 * 额度逻辑处理层接口类
 *
 * @author kongdezhi
 */
public interface BalanceService {

    /**
     * 分页查询
     *
     * @param pageSize 每页条数
     * @param pageNum  当前页
     * @return 查询结果
     */
    PageInfo<Balance> queryAllByLimit(Integer pageNum, Integer pageSize);

    /**
     * 根据id查询额度
     *
     * @param id 额度id
     * @return 查询结果
     */
    Balance queryById(long id);

    /**
     * 查询所有额度
     *
     * @return 查询结果
     */
    List<Balance> queryAll();

    /**
     * 额度表关联ccids查询
     *
     * @return 查询结果
     */
    List<Balance> queryAllByRelatedCcids();

    /**
     * 从ES中进行额度条件词查询
     *
     * @param balanceQueryDTO 额度查询条件封装类
     * @return 查询结果
     */
    AggregatedPage<Balance> querySpecifiedFieldByConditionWord(BalanceQueryDTO balanceQueryDTO);
}
