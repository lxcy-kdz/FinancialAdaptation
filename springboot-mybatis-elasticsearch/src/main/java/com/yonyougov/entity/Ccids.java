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

    @Field(type = FieldType.Keyword)
    private Long coaId;

    @Field(type = FieldType.Keyword)
    private String tbId;

    @Field(type = FieldType.Keyword)
    private String tbCode;

    @Field(type = FieldType.Keyword)
    private String tbName;

    @Field(type = FieldType.Keyword)
    private String ifaccId;

    @Field(type = FieldType.Keyword)
    private String ifaccCode;

    @Field(type = FieldType.Keyword)
    private String ifaccName;

    @Field(type = FieldType.Keyword)
    private String paySummaryId;

    @Field(type = FieldType.Keyword)
    private String paySummaryCode;

    @Field(type = FieldType.Keyword)
    private String paySummaryName;

    @Field(type = FieldType.Keyword)
    private String agentAccountId;

    @Field(type = FieldType.Keyword)
    private String agentAccountCode;

    @Field(type = FieldType.Keyword)
    private String agentAccountName;

    @Field(type = FieldType.Keyword)
    private String accountczTypeId;

    @Field(type = FieldType.Keyword)
    private String accountczTypeCode;

    @Field(type = FieldType.Keyword)
    private String accountczTypeName;

    @Field(type = FieldType.Keyword)
    private String accountTypeId;

    @Field(type = FieldType.Keyword)
    private String accountTypeCode;

    @Field(type = FieldType.Keyword)
    private String accountTypeName;

    @Field(type = FieldType.Keyword)
    private String asId;

    @Field(type = FieldType.Keyword)
    private String asCode;

    @Field(type = FieldType.Keyword)
    private String asName;

    @Field(type = FieldType.Keyword)
    private String mbId;

    @Field(type = FieldType.Keyword)
    private String mbCode;

    @Field(type = FieldType.Keyword)
    private String mbName;

    @Field(type = FieldType.Keyword)
    private String agencyId;

    @Field(type = FieldType.Keyword)
    private String agencyCode;

    @Field(type = FieldType.Keyword)
    private String agencyName;

    @Field(type = FieldType.Keyword)
    private String fundtypeId;

    @Field(type = FieldType.Keyword)
    private String fundtypeCode;

    @Field(type = FieldType.Keyword)
    private String fundtypeName;

    @Field(type = FieldType.Keyword)
    private String expfuncId;

    @Field(type = FieldType.Keyword)
    private String expfuncCode;

    @Field(type = FieldType.Keyword)
    private String expfuncName;

    @Field(type = FieldType.Keyword)
    private String agencyexpId;

    @Field(type = FieldType.Keyword)
    private String agencyexpCode;

    @Field(type = FieldType.Keyword)
    private String agencyexpName;

    @Field(type = FieldType.Keyword)
    private String expecoId;

    @Field(type = FieldType.Keyword)
    private String expecoCode;

    @Field(type = FieldType.Keyword)
    private String expecoName;

    @Field(type = FieldType.Keyword)
    private String paytypeId;

    @Field(type = FieldType.Keyword)
    private String paytypeCode;

    @Field(type = FieldType.Keyword)
    private String paytypeName;

    @Field(type = FieldType.Keyword)
    private String bgttypeId;

    @Field(type = FieldType.Keyword)
    private String bgttypeCode;

    @Field(type = FieldType.Keyword)
    private String bgttypeName;

    @Field(type = FieldType.Keyword)
    private String paykindId;

    @Field(type = FieldType.Keyword)
    private String paykindCode;

    @Field(type = FieldType.Keyword)
    private String paykindName;

    @Field(type = FieldType.Keyword)
    private String fileId;

    @Field(type = FieldType.Keyword)
    private String fileCode;

    @Field(type = FieldType.Keyword)
    private String fileName;

    @Field(type = FieldType.Keyword)
    private String setmodeId;

    @Field(type = FieldType.Keyword)
    private String setmodeCode;

    @Field(type = FieldType.Keyword)
    private String setmodeName;

    @Field(type = FieldType.Keyword)
    private String inBsId;

    @Field(type = FieldType.Keyword)
    private String inBsCode;

    @Field(type = FieldType.Keyword)
    private String inBsName;

    @Field(type = FieldType.Keyword)
    private String inBisId;

    @Field(type = FieldType.Keyword)
    private String inBisCode;

    @Field(type = FieldType.Keyword)
    private String inBisName;

    @Field(type = FieldType.Keyword)
    private String cbId;

    @Field(type = FieldType.Keyword)
    private String cbCode;

    @Field(type = FieldType.Keyword)
    private String cbName;

    @Field(type = FieldType.Keyword)
    private String pbId;

    @Field(type = FieldType.Keyword)
    private String pbCode;

    @Field(type = FieldType.Keyword)
    private String pbName;

    @Field(type = FieldType.Keyword)
    private String ibId;

    @Field(type = FieldType.Keyword)
    private String ibCode;

    @Field(type = FieldType.Keyword)
    private String ibName;

    @Field(type = FieldType.Keyword)
    private String bacId;

    @Field(type = FieldType.Keyword)
    private String bacCode;

    @Field(type = FieldType.Keyword)
    private String bacName;

    @Field(type = FieldType.Keyword)
    private String bapId;

    @Field(type = FieldType.Keyword)
    private String bapCode;

    @Field(type = FieldType.Keyword)
    private String bapName;

    @Field(type = FieldType.Keyword)
    private String baiId;

    @Field(type = FieldType.Keyword)
    private String baiCode;

    @Field(type = FieldType.Keyword)
    private String baiName;

    @Field(type = FieldType.Keyword)
    private String bgtdirId;

    @Field(type = FieldType.Keyword)
    private String bgtdirCode;

    @Field(type = FieldType.Keyword)
    private String bgtdirName;

    @Field(type = FieldType.Keyword)
    private String bpId;

    @Field(type = FieldType.Keyword)
    private String bpCode;

    @Field(type = FieldType.Keyword)
    private String bpName;

    @Field(type = FieldType.Keyword)
    private String bgtsourceId;

    @Field(type = FieldType.Keyword)
    private String bgtsourceCode;

    @Field(type = FieldType.Keyword)
    private String bgtsourceName;

    @Field(type = FieldType.Keyword)
    private String bisId;

    @Field(type = FieldType.Keyword)
    private String bisCode;

    @Field(type = FieldType.Keyword)
    private String bisName;

    @Field(type = FieldType.Keyword)
    private String inpmId;

    @Field(type = FieldType.Keyword)
    private String inpmCode;

    @Field(type = FieldType.Keyword)
    private String inpmName;

    @Field(type = FieldType.Keyword)
    private String stId;

    @Field(type = FieldType.Keyword)
    private String stCode;

    @Field(type = FieldType.Keyword)
    private String stName;

    @Field(type = FieldType.Keyword)
    private String ctId;

    @Field(type = FieldType.Keyword)
    private String ctCode;

    @Field(type = FieldType.Keyword)
    private String ctName;

    @Field(type = FieldType.Keyword)
    private String smId;

    @Field(type = FieldType.Keyword)
    private String smCode;

    @Field(type = FieldType.Keyword)
    private String smName;

    @Field(type = FieldType.Keyword)
    private String opuserId;

    @Field(type = FieldType.Keyword)
    private String opuserCode;

    @Field(type = FieldType.Keyword)
    private String opuserName;

    @Field(type = FieldType.Keyword)
    private String editorId;

    @Field(type = FieldType.Keyword)
    private String editorCode;

    @Field(type = FieldType.Keyword)
    private String editorName;

    @Field(type = FieldType.Keyword)
    private String zfcgbsId;

    @Field(type = FieldType.Keyword)
    private String zfcgbsCode;

    @Field(type = FieldType.Keyword)
    private String zfcgbsName;

    @Field(type = FieldType.Keyword)
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

    @Field(type = FieldType.Keyword)
    private String pfId;

    @Field(type = FieldType.Keyword)
    private String pfCode;

    @Field(type = FieldType.Keyword)
    private String pfName;

    @Field(type = FieldType.Keyword)
    private String groupIdId;

    @Field(type = FieldType.Keyword)
    private String groupIdCode;

    @Field(type = FieldType.Keyword)
    private String groupIdName;

    @Field(type = FieldType.Keyword)
    private String useenId;

    @Field(type = FieldType.Keyword)
    private String useenCode;

    @Field(type = FieldType.Keyword)
    private String useenName;

    @Field(type = FieldType.Keyword)
    private String provId;

    @Field(type = FieldType.Keyword)
    private String provCode;

    @Field(type = FieldType.Keyword)
    private String provName;

    @Field(type = FieldType.Keyword)
    private String gpAgencyId;

    @Field(type = FieldType.Keyword)
    private String gpAgencyCode;

    @Field(type = FieldType.Keyword)
    private String gpAgencyName;

    @Field(type = FieldType.Keyword)
    private String modeId;

    @Field(type = FieldType.Keyword)
    private String modeCode;

    @Field(type = FieldType.Keyword)
    private String modeName;

    @Field(type = FieldType.Keyword)
    private String fasnId;

    @Field(type = FieldType.Keyword)
    private String fasnCode;

    @Field(type = FieldType.Keyword)
    private String fasnName;

    @Field(type = FieldType.Keyword)
    private String dirId;

    @Field(type = FieldType.Keyword)
    private String dirCode;

    @Field(type = FieldType.Keyword)
    private String dirName;

    @Field(type = FieldType.Keyword)
    private String gpplanId;

    @Field(type = FieldType.Keyword)
    private String gpplanCode;

    @Field(type = FieldType.Keyword)
    private String gpplanName;

    @Field(type = FieldType.Keyword)
    private String gpbarnId;

    @Field(type = FieldType.Keyword)
    private String gpbarnCode;

    @Field(type = FieldType.Keyword)
    private String gpbarnName;

    @Field(type = FieldType.Keyword)
    private String waId;

    @Field(type = FieldType.Keyword)
    private String waCode;

    @Field(type = FieldType.Keyword)
    private String waName;

    @Field(type = FieldType.Keyword)
    private String ffId;

    @Field(type = FieldType.Keyword)
    private String ffName;

    @Field(type = FieldType.Keyword)
    private String ffCode;

    @Field(type = FieldType.Keyword)
    private String ienId;

    @Field(type = FieldType.Keyword)
    private String ienName;

    @Field(type = FieldType.Keyword)
    private String ienCode;

    @Field(type = FieldType.Keyword)
    private String gzbsId;

    @Field(type = FieldType.Keyword)
    private String gzbsName;

    @Field(type = FieldType.Keyword)
    private String gzbsCode;

    @Field(type = FieldType.Keyword)
    private String bcId;

    @Field(type = FieldType.Keyword)
    private String bcCode;

    @Field(type = FieldType.Keyword)
    private String bcName;

    @Field(type = FieldType.Keyword)
    private String bsoId;

    @Field(type = FieldType.Keyword)
    private String bsoCode;

    @Field(type = FieldType.Keyword)
    private String bsoName;

    @Field(type = FieldType.Keyword)
    private String aeId;

    @Field(type = FieldType.Keyword)
    private String aeCode;

    @Field(type = FieldType.Keyword)
    private String aeName;

    @Field(type = FieldType.Keyword)
    private String budgetvouId;

    @Field(type = FieldType.Keyword)
    private String budgetvouCode;

    @Field(type = FieldType.Keyword)
    private String budgetvouName;

    @Field(type = FieldType.Keyword)
    private String gpvouId;

    @Field(type = FieldType.Keyword)
    private String gpvouCode;

    @Field(type = FieldType.Keyword)
    private String gpvouName;

    @Field(type = FieldType.Keyword)
    private String govExpecoId;

    @Field(type = FieldType.Keyword)
    private String govExpecoCode;

    @Field(type = FieldType.Keyword)
    private String govExpecoName;

    @Field(type = FieldType.Keyword)
    private String managebranchId;

    @Field(type = FieldType.Keyword)
    private String managebranchCode;

    @Field(type = FieldType.Keyword)
    private String managebranchName;

    @Field(type = FieldType.Keyword)
    private String md5;

    @Field(type = FieldType.Keyword)
    private Long ccid;

    @Field(type = FieldType.Integer)
    private int year;

    @Field(type = FieldType.Keyword)
    private String admDivCode;

    @Field(type = FieldType.Keyword)
    private String hold1Code;

    @Field(type = FieldType.Keyword)
    private String hold1Id = "";

    @Field(type = FieldType.Keyword)
    private String hold1Name;

    @Field(type = FieldType.Keyword)
    private String hold2Code;

    @Field(type = FieldType.Keyword)
    private String hold2Id = "";

    @Field(type = FieldType.Keyword)
    private String hold2Name;

    @Field(type = FieldType.Keyword)
    private String hold3Code;

    @Field(type = FieldType.Keyword)
    private String hold3Id = "";

    @Field(type = FieldType.Keyword)
    private String hold3Name;

    @Field(type = FieldType.Keyword)
    private String hold4Code;

    @Field(type = FieldType.Keyword)
    private String hold4Id = "";

    @Field(type = FieldType.Keyword)
    private String hold4Name;

    @Field(type = FieldType.Keyword)
    private String hold5Code;

    @Field(type = FieldType.Keyword)
    private String hold5Id = "";

    @Field(type = FieldType.Keyword)
    private String hold5Name;

    @Field(type = FieldType.Keyword)
    private String hold6Code;

    @Field(type = FieldType.Keyword)
    private String hold6Id = "";

    @Field(type = FieldType.Keyword)
    private String hold6Name;

    @Field(type = FieldType.Keyword)
    private String hold7Code;

    @Field(type = FieldType.Keyword)
    private String hold7Id = "";

    @Field(type = FieldType.Keyword)
    private String hold7Name;

    @Field(type = FieldType.Keyword)
    private String hold8Code;

    @Field(type = FieldType.Keyword)
    private String hold8Id = "";

    @Field(type = FieldType.Keyword)
    private String hold8Name;

    @Field(type = FieldType.Keyword)
    private String hold9Code;

    @Field(type = FieldType.Keyword)
    private String hold9Id = "";

    @Field(type = FieldType.Keyword)
    private String hold9Name;

    @Field(type = FieldType.Keyword)
    private String hold10Code;

    @Field(type = FieldType.Keyword)
    private String hold10Id = "";

    @Field(type = FieldType.Keyword)
    private String hold10Name;

    @Field(type = FieldType.Keyword)
    private String filesuperId;

    @Field(type = FieldType.Keyword)
    private String filesuperCode;

    @Field(type = FieldType.Keyword)
    private String filesuperName;

    @Field(type = FieldType.Keyword)
    private String budgetgroupId;

    @Field(type = FieldType.Keyword)
    private String budgetgroupCode;

    @Field(type = FieldType.Keyword)
    private String budgetgroupName;

    /**
     * 采购品目
     */
    @Field(type = FieldType.Keyword)
    private String catalogueId;

    @Field(type = FieldType.Keyword)
    private String catalogueCode;

    @Field(type = FieldType.Keyword)
    private String catalogueName;

    /**
     * 专管员
     */
    @Field(type = FieldType.Keyword)
    private String specialstaffId;

    @Field(type = FieldType.Keyword)
    private String specialstaffCode;

    @Field(type = FieldType.Keyword)
    private String specialstaffName;

    /**
     * 项目
     */
    @Field(type = FieldType.Keyword)
    private String projectsId;

    @Field(type = FieldType.Keyword)
    private String projectsCode;

    @Field(type = FieldType.Keyword)
    private String projectsName;

    @Field(type = FieldType.Keyword)
    private String puritemId;

    @Field(type = FieldType.Keyword)
    private String puritemCode;

    @Field(type = FieldType.Keyword)
    private String puritemName;

    @Field(type = FieldType.Keyword)
    private String supbgtdocnoId;

    @Field(type = FieldType.Keyword)
    private String supbgtdocnoCode;

    @Field(type = FieldType.Keyword)
    private String supbgtdocnoName;

    @Field(type = FieldType.Keyword)
    private Long createBy;

    @Field(type = FieldType.Date)
    private Date createDate;

    @Field(type = FieldType.Keyword)
    private Long lastModifiedBy;

    @Field(type = FieldType.Date)
    private Date lastModifiedDate;

    private Integer lastModifiedVersion;

}
