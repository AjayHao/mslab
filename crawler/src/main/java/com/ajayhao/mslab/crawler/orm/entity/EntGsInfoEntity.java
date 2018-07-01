package com.ajayhao.mslab.crawler.orm.entity;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
public class EntGsInfoEntity extends BaseEntDataEntity{

    private String regNo;

    private String oriRegNo;

    private String creditCode;

    private String frName;

    private BigDecimal regCap;

    private String regCapCur;

    private String entStatus;

    private String entType;

    private String esDate;

    private String opFrom;

    private String opTo;

    private String regAddr;

    private String regOrg;

    private String regOrgCode;

    private String regOrgProvince;

    private Long empNum;

    private String tel;

    private String opLocation;

    private String industryCode;

    private String industryName;

    private String opScope;

}