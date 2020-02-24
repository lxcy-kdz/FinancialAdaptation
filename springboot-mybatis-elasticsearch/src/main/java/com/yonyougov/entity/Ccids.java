package com.yonyougov.entity;

import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.Date;

/**
 * ccidModel
 *
 * @author kongdezhi
 */
@Data
public class Ccids {

    private Long id;

    private Long coaId;

    private String tbId;

    @Field(type = FieldType.Keyword)
    private String tbCode;

    @Field(type = FieldType.Keyword)
    private String tbName;

    private String ifaccId;

    @Field(type = FieldType.Keyword)
    private String ifaccCode;

    @Field(type = FieldType.Keyword)
    private String ifaccName;

    private String paySummaryId;

    @Field(type = FieldType.Keyword)
    private String paySummaryCode;

    @Field(type = FieldType.Keyword)
    private String paySummaryName;

    private String agentAccountId;

    @Field(type = FieldType.Keyword)
    private String agentAccountCode;

    @Field(type = FieldType.Keyword)
    private String agentAccountName;

    private String accountczTypeId;

    @Field(type = FieldType.Keyword)
    private String accountczTypeCode;

    @Field(type = FieldType.Keyword)
    private String accountczTypeName;

    private String accountTypeId;

    @Field(type = FieldType.Keyword)
    private String accountTypeCode;

    @Field(type = FieldType.Keyword)
    private String accountTypeName;

    private String asId;

    @Field(type = FieldType.Keyword)
    private String asCode;

    @Field(type = FieldType.Keyword)
    private String asName;

    private String mbId;

    @Field(type = FieldType.Keyword)
    private String mbCode;

    @Field(type = FieldType.Keyword)
    private String mbName;

    private String agencyId;

    @Field(type = FieldType.Keyword)
    private String agencyCode;

    @Field(type = FieldType.Keyword)
    private String agencyName;

    private String fundtypeId;

    @Field(type = FieldType.Keyword)
    private String fundtypeCode;

    @Field(type = FieldType.Keyword)
    private String fundtypeName;

    private String expfuncId;

    @Field(type = FieldType.Keyword)
    private String expfuncCode;

    @Field(type = FieldType.Keyword)
    private String expfuncName;

    private String agencyexpId;

    @Field(type = FieldType.Keyword)
    private String agencyexpCode;

    @Field(type = FieldType.Keyword)
    private String agencyexpName;

    private String expecoId;

    @Field(type = FieldType.Keyword)
    private String expecoCode;

    @Field(type = FieldType.Keyword)
    private String expecoName;

    private String paytypeId;

    @Field(type = FieldType.Keyword)
    private String paytypeCode;

    @Field(type = FieldType.Keyword)
    private String paytypeName;

    private String bgttypeId;

    @Field(type = FieldType.Keyword)
    private String bgttypeCode;


    @Field(type = FieldType.Keyword)
    private String bgttypeName;

    private String paykindId;

    @Field(type = FieldType.Keyword)
    private String paykindCode;

    @Field(type = FieldType.Keyword)
    private String paykindName;

    private String fileId;

    @Field(type = FieldType.Keyword)
    private String fileCode;

    @Field(type = FieldType.Keyword)
    private String fileName;

    private String setmodeId;

    @Field(type = FieldType.Keyword)
    private String setmodeCode;

    @Field(type = FieldType.Keyword)
    private String setmodeName;

    private String inBsId;

    @Field(type = FieldType.Keyword)
    private String inBsCode;

    @Field(type = FieldType.Keyword)
    private String inBsName;

    private String inBisId;

    @Field(type = FieldType.Keyword)
    private String inBisCode;

    @Field(type = FieldType.Keyword)
    private String inBisName;

    private String cbId;

    @Field(type = FieldType.Keyword)
    private String cbCode;

    @Field(type = FieldType.Keyword)
    private String cbName;

    private String pbId;

    @Field(type = FieldType.Keyword)
    private String pbCode;

    @Field(type = FieldType.Keyword)
    private String pbName;

    private String ibId;

    @Field(type = FieldType.Keyword)
    private String ibCode;

    @Field(type = FieldType.Keyword)
    private String ibName;

    private String bacId;

    @Field(type = FieldType.Keyword)
    private String bacCode;

    @Field(type = FieldType.Keyword)
    private String bacName;

    private String bapId;

    @Field(type = FieldType.Keyword)
    private String bapCode;

    @Field(type = FieldType.Keyword)
    private String bapName;

    private String baiId;

    @Field(type = FieldType.Keyword)
    private String baiCode;

    @Field(type = FieldType.Keyword)
    private String baiName;

    private String bgtdirId;

    @Field(type = FieldType.Keyword)
    private String bgtdirCode;

    @Field(type = FieldType.Keyword)
    private String bgtdirName;

    private String bpId;

    @Field(type = FieldType.Keyword)
    private String bpCode;

    @Field(type = FieldType.Keyword)
    private String bpName;

    private String bgtsourceId;

    @Field(type = FieldType.Keyword)
    private String bgtsourceCode;

    @Field(type = FieldType.Keyword)
    private String bgtsourceName;

    private String bisId;

    @Field(type = FieldType.Keyword)
    private String bisCode;

    @Field(type = FieldType.Keyword)
    private String bisName;

    private String inpmId;

    @Field(type = FieldType.Keyword)
    private String inpmCode;

    @Field(type = FieldType.Keyword)
    private String inpmName;

    private String stId;

    @Field(type = FieldType.Keyword)
    private String stCode;

    @Field(type = FieldType.Keyword)
    private String stName;

    private String ctId;

    @Field(type = FieldType.Keyword)
    private String ctCode;

    @Field(type = FieldType.Keyword)
    private String ctName;

    private String smId;

    @Field(type = FieldType.Keyword)
    private String smCode;

    @Field(type = FieldType.Keyword)
    private String smName;

    private String opuserId;

    @Field(type = FieldType.Keyword)
    private String opuserCode;

    @Field(type = FieldType.Keyword)
    private String opuserName;

    private String editorId;

    @Field(type = FieldType.Keyword)
    private String editorCode;

    @Field(type = FieldType.Keyword)
    private String editorName;

    private String zfcgbsId;

    @Field(type = FieldType.Keyword)
    private String zfcgbsCode;

    @Field(type = FieldType.Keyword)
    private String zfcgbsName;

    private String fmId;

    @Field(type = FieldType.Keyword)
    private String fmCode;

    @Field(type = FieldType.Keyword)
    private String fmName;

    @Field(type = FieldType.Keyword)
    private String payaccountno;

    @Field(type = FieldType.Keyword)
    private String payaccountName;

    @Field(type = FieldType.Keyword)
    private String payaccountbank;

    @Field(type = FieldType.Keyword)
    private String clearaccountno;

    @Field(type = FieldType.Keyword)
    private String clearaccountName;

    @Field(type = FieldType.Keyword)
    private String clearaccountbank;

    @Field(type = FieldType.Keyword)
    private String incomeaccountno;

    @Field(type = FieldType.Keyword)
    private String incomeaccountName;

    @Field(type = FieldType.Keyword)
    private String incomeaccountbank;

    private String pfId;

    @Field(type = FieldType.Keyword)
    private String pfCode;

    @Field(type = FieldType.Keyword)
    private String pfName;

    private String groupIdId;

    @Field(type = FieldType.Keyword)
    private String groupIdCode;

    @Field(type = FieldType.Keyword)
    private String groupIdName;

    private String useenId;

    @Field(type = FieldType.Keyword)
    private String useenCode;

    @Field(type = FieldType.Keyword)
    private String useenName;

    private String provId;

    @Field(type = FieldType.Keyword)
    private String provCode;

    @Field(type = FieldType.Keyword)
    private String provName;

    private String gpAgencyId;

    @Field(type = FieldType.Keyword)
    private String gpAgencyCode;

    @Field(type = FieldType.Keyword)
    private String gpAgencyName;

    private String modeId;

    @Field(type = FieldType.Keyword)
    private String modeCode;

    @Field(type = FieldType.Keyword)
    private String modeName;

    private String fasnId;

    @Field(type = FieldType.Keyword)
    private String fasnCode;

    @Field(type = FieldType.Keyword)
    private String fasnName;

    private String dirId;

    @Field(type = FieldType.Keyword)
    private String dirCode;

    @Field(type = FieldType.Keyword)
    private String dirName;

    private String gpplanId;

    @Field(type = FieldType.Keyword)
    private String gpplanCode;

    @Field(type = FieldType.Keyword)
    private String gpplanName;

    private String gpbarnId;

    @Field(type = FieldType.Keyword)
    private String gpbarnCode;

    @Field(type = FieldType.Keyword)
    private String gpbarnName;

    private String waId;

    @Field(type = FieldType.Keyword)
    private String waCode;

    @Field(type = FieldType.Keyword)
    private String waName;

    private String ffId;

    @Field(type = FieldType.Keyword)
    private String ffName;

    @Field(type = FieldType.Keyword)
    private String ffCode;

    private String ienId;

    @Field(type = FieldType.Keyword)
    private String ienName;

    @Field(type = FieldType.Keyword)
    private String ienCode;

    private String gzbsId;

    @Field(type = FieldType.Keyword)
    private String gzbsName;

    @Field(type = FieldType.Keyword)
    private String gzbsCode;

    private String bcId;

    @Field(type = FieldType.Keyword)
    private String bcCode;

    @Field(type = FieldType.Keyword)
    private String bcName;

    private String bsoId;

    @Field(type = FieldType.Keyword)
    private String bsoCode;

    @Field(type = FieldType.Keyword)
    private String bsoName;

    private String aeId;

    @Field(type = FieldType.Keyword)
    private String aeCode;

    @Field(type = FieldType.Keyword)
    private String aeName;

    private String budgetvouId;

    @Field(type = FieldType.Keyword)
    private String budgetvouCode;

    @Field(type = FieldType.Keyword)
    private String budgetvouName;

    private String gpvouId;

    @Field(type = FieldType.Keyword)
    private String gpvouCode;

    @Field(type = FieldType.Keyword)
    private String gpvouName;

    private String govExpecoId;

    @Field(type = FieldType.Keyword)
    private String govExpecoCode;

    @Field(type = FieldType.Keyword)
    private String govExpecoName;

    private String managebranchId;

    @Field(type = FieldType.Keyword)
    private String managebranchCode;

    @Field(type = FieldType.Keyword)
    private String managebranchName;

    private String md5;

    private Long ccid;

    @Field(type = FieldType.Integer)
    private int year;

    @Field(type = FieldType.Keyword)
    private String admDivCode;

    @Field(type = FieldType.Keyword)
    private String hold1Code;

    private String hold1Id = "";

    @Field(type = FieldType.Keyword)
    private String hold1Name;

    @Field(type = FieldType.Keyword)
    private String hold2Code;

    private String hold2Id = "";

    @Field(type = FieldType.Keyword)
    private String hold2Name;

    @Field(type = FieldType.Keyword)
    private String hold3Code;

    private String hold3Id = "";

    @Field(type = FieldType.Keyword)
    private String hold3Name;

    @Field(type = FieldType.Keyword)
    private String hold4Code;

    private String hold4Id = "";

    @Field(type = FieldType.Keyword)
    private String hold4Name;

    @Field(type = FieldType.Keyword)
    private String hold5Code;

    private String hold5Id = "";

    @Field(type = FieldType.Keyword)
    private String hold5Name;

    @Field(type = FieldType.Keyword)
    private String hold6Code;

    private String hold6Id = "";

    @Field(type = FieldType.Keyword)
    private String hold6Name;

    @Field(type = FieldType.Keyword)
    private String hold7Code;

    private String hold7Id = "";

    @Field(type = FieldType.Keyword)
    private String hold7Name;

    @Field(type = FieldType.Keyword)
    private String hold8Code;

    private String hold8Id = "";

    @Field(type = FieldType.Keyword)
    private String hold8Name;

    @Field(type = FieldType.Keyword)
    private String hold9Code;

    private String hold9Id = "";

    @Field(type = FieldType.Keyword)
    private String hold9Name;

    @Field(type = FieldType.Keyword)
    private String hold10Code;

    private String hold10Id = "";

    @Field(type = FieldType.Keyword)
    private String hold10Name;

    private String filesuperId;

    @Field(type = FieldType.Keyword)
    private String filesuperCode;

    @Field(type = FieldType.Keyword)
    private String filesuperName;

    private String budgetgroupId;

    @Field(type = FieldType.Keyword)
    private String budgetgroupCode;

    @Field(type = FieldType.Keyword)
    private String budgetgroupName;

    /**
     * 采购品目
     */
    private String catalogueId;

    @Field(type = FieldType.Keyword)
    private String catalogueCode;

    @Field(type = FieldType.Keyword)
    private String catalogueName;

    /**
     * 专管员
     */
    private String specialstaffId;

    @Field(type = FieldType.Keyword)
    private String specialstaffCode;

    @Field(type = FieldType.Keyword)
    private String specialstaffName;

    /**
     * 项目
     */

    private String projectsId;

    @Field(type = FieldType.Keyword)
    private String projectsCode;

    @Field(type = FieldType.Keyword)
    private String projectsName;

    private String puritemId;

    @Field(type = FieldType.Keyword)
    private String puritemCode;

    @Field(type = FieldType.Keyword)
    private String puritemName;

    private String supbgtdocnoId;

    @Field(type = FieldType.Keyword)
    private String supbgtdocnoCode;

    @Field(type = FieldType.Keyword)
    private String supbgtdocnoName;

    private Long createBy;

    private Date createDate;

    private Long lastModifiedBy;

    private Date lastModifiedDate;

    private Integer lastModifiedVersion;

}
