package com.yonyougov.mapper;

import com.yonyougov.entity.Ccids;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (FglCcids)表数据库访问层
 *
 * @author makejava
 * @since 2020-02-23 20:36:07
 */
@Mapper
public interface CcidsMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Ccids queryById(Object id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Ccids> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param fglCcids 实例对象
     * @return 对象列表
     */
    List<Ccids> queryAll(Ccids fglCcids);

    /**
     * 新增数据
     *
     * @param fglCcids 实例对象
     * @return 影响行数
     */
    int insert(Ccids fglCcids);

    /**
     * 修改数据
     *
     * @param fglCcids 实例对象
     * @return 影响行数
     */
    int update(Ccids fglCcids);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Object id);

}