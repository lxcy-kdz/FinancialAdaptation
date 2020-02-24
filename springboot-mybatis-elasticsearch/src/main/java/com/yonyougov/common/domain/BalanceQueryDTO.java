package com.yonyougov.common.domain;

import lombok.Data;

/**
 * 额度查询DTO
 *
 * @author kongdezhi
 */
@Data
public class BalanceQueryDTO {

    private Integer pageSize;

    private Integer pageNum;

    private String[] fetchField;

    private String[] returnField;

    private String conditionWord;
}
