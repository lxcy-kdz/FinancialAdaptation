package com.yonyougov.common.domain;

import lombok.Data;
import org.elasticsearch.search.sort.SortOrder;

import java.util.HashMap;

/**
 * 额度查询DTO
 *
 * @author kongdezhi
 */
@Data
public class BalanceQueryDTO {

    /**
     * 每页显示条数
     **/
    private Integer pageSize;

    /**
     * 当前页
     **/
    private Integer pageNum;

    /**
     * 查询指定字段域
     **/
    private String[] fetchField;

    /**
     * 返回字段域
     **/
    private String[] returnField;

    /**
     * 模糊查询条件词
     **/
    private String conditionWord;

    /**
     * and 查询条件
     */
    private HashMap<String, String> andConditionMap;

    /**
     * 模拟权限条件
     */
    private HashMap<String, String[]> permissionCondition;

    /**
     * 排序条件
     */
    private HashMap<String, SortOrder> sortCondition;

    /**
     * 求和统计字段
     */
    private String[] sumFields;

    /**
     * 分组字段
     */
    private String groupField;
}
