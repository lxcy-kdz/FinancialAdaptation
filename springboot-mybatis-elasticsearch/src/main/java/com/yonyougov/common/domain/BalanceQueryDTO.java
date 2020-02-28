package com.yonyougov.common.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.elasticsearch.search.sort.SortOrder;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * 额度查询DTO
 *
 * @author kongdezhi
 */
@Data
@ApiModel
public class BalanceQueryDTO {

    /**
     * 每页显示条数
     **/
    @ApiModelProperty("每页显示条数")
    private Integer pageSize;

    /**
     * 当前页
     **/
    @ApiModelProperty("当前页")
    private Integer pageNum;

    /**
     * 查询指定字段域
     **/
    @ApiModelProperty("查询指定字段域")
    private String[] fetchField;

    /**
     * 返回字段域
     **/
    @ApiModelProperty("返回字段域")
    private String[] returnField;

    /**
     * 模糊查询条件词
     **/
    @ApiModelProperty("模糊查询条件词")
    private String conditionWord;

    /**
     * and 查询条件
     */
    @ApiModelProperty("查询条件")
    private Map<String, String> andConditionMap;

    /**
     * 模拟权限条件
     */
    @ApiModelProperty("模拟权限条件")
    private Map<String, String[]> permissionCondition;

    /**
     * 排序条件
     */
    @ApiModelProperty("排序条件")
    private Map<String, SortOrder> sortCondition;

    /**
     * 求和统计字段
     */
    @ApiModelProperty("求和统计字段")
    private String[] sumFields;

    /**
     * 分组字段
     */
    @ApiModelProperty("分组字段")
    private String groupField;

    /**
     * 对指定金额字段进行范围查询
     */
    private Map<String, String[]> moneyRange;
}
