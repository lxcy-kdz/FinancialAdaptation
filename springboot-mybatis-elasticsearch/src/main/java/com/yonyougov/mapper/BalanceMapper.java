package com.yonyougov.mapper;

import com.yonyougov.entity.Balance;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (FglBalance)表数据库访问层
 *
 * @author makejava
 * @since 2020-02-23 20:29:57
 */
@Mapper
public interface BalanceMapper {

    /**
     * 额度表关联ccids查询
     *
     * @return 查询结果
     */
    List<Balance> queryAllByRelatedCcids();

    /**
     * 查询所有
     *
     * @return 实例对象
     */
    List<Balance> queryAll();

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Balance queryById(Long id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Balance> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param fglBalance 实例对象
     * @return 对象列表
     */
    List<Balance> queryAllByCondition(Balance fglBalance);

    /**
     * 新增数据
     *
     * @param fglBalance 实例对象
     * @return 影响行数
     */
    int insert(Balance fglBalance);

    /**
     * 修改数据
     *
     * @param fglBalance 实例对象
     * @return 影响行数
     */
    int update(Balance fglBalance);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

}