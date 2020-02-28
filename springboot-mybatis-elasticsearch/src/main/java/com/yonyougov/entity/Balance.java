package com.yonyougov.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 额度Model
 *
 * @author kongdezhi
 */
@Data
@Document(indexName = "balance", type = "_doc")
public class Balance {

    @Id
    private Long id;

    @Field(type = FieldType.Keyword)
    private Long sumId;

    @Field(type = FieldType.Keyword)
    private Long fromctrlid;

    @Field(type = FieldType.Keyword)
    private Long secondFromctrlid;

    @Field(type = FieldType.Keyword)
    private Long accountId;

    @Field(type = FieldType.Keyword)
    private Integer month;

    @Field(type = FieldType.Double)
    private BigDecimal aviMoney;

    @Field(type = FieldType.Double)
    private BigDecimal useMoney;

    @Field(type = FieldType.Double)
    private BigDecimal minusMoney;

    @Field(type = FieldType.Double)
    private BigDecimal avingMoney;

    @Field(type = FieldType.Keyword)
    private String remark;

    @Field(type = FieldType.Keyword)
    private Long ccid;

    @Field(type = FieldType.Integer)
    private Integer year;

    @Field(type = FieldType.Keyword)
    private String admDivCode;

    @Field(type = FieldType.Keyword)
    private Long balanceId;

    @Field(type = FieldType.Double)
    private BigDecimal increasingMoney;

    @Field(type = FieldType.Double)
    private BigDecimal increaseMoney;

    @Field(type = FieldType.Double)
    private BigDecimal adjustMinusingMoney;

    @Field(type = FieldType.Double)
    private BigDecimal adjustMinusMoney;

    @Field(type = FieldType.Double)
    private BigDecimal freezingMoney;

    @Field(type = FieldType.Double)
    private BigDecimal freezeMoney;

    @Field(type = FieldType.Double)
    private BigDecimal unfreezingMoney;

    @Field(type = FieldType.Double)
    private BigDecimal unfreezeMoney;

    @Field(type = FieldType.Double)
    private BigDecimal adjustIncreasingMoney;

    @Field(type = FieldType.Double)
    private BigDecimal adjustIncreaseMoney;

    @Field(type = FieldType.Double)
    private BigDecimal distributeMoney;

    @Field(type = FieldType.Double)
    private BigDecimal distributingMoney;

    @Field(type = FieldType.Double)
    private BigDecimal distributeMinusingMoney;

    @Field(type = FieldType.Double)
    private BigDecimal distributeMinusEndMoney;

    @Field(type = FieldType.Double)
    private BigDecimal usingMoney;

    @Field(type = FieldType.Double)
    private BigDecimal useEndMoney;

    @Field(type = FieldType.Double)
    private BigDecimal recoveringMoney;

    @Field(type = FieldType.Double)
    private BigDecimal recoverMoney;

    @Field(type = FieldType.Double)
    private BigDecimal minusingMoney;

    @Field(type = FieldType.Double)
    private BigDecimal minusEndMoney;

    @Field(type = FieldType.Double)
    private BigDecimal distributeFreezingMoney;

    @Field(type = FieldType.Double)
    private BigDecimal distributeFreezeMoney;

    @Field(type = FieldType.Double)
    private BigDecimal distributeUnfreezingMoney;

    @Field(type = FieldType.Double)
    private BigDecimal distributeUnfreezeMoney;

    @Field(type = FieldType.Double)
    private BigDecimal verificationingMoney;

    @Field(type = FieldType.Double)
    private BigDecimal verificationMoney;

    @Field(type = FieldType.Double)
    private BigDecimal canUseMoney;

    private Long createBy;

    @Field(type = FieldType.Date)
    private Date createDate;

    private Long lastModifiedBy;

    @Field(type = FieldType.Date)
    private Date lastModifiedDate;

    private Integer lastModifiedVersion;

    @Field(type = FieldType.Object)
    private Ccids ccids;

}
