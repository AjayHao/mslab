package com.ajayhao.mslab.crawler.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Setter
@Getter
public class EntGsInfo implements Serializable{

    private static final long serialVersionUID = 1L;

    private String entId;

    private String entName;

    private String pullDate;

    private String regNo;

    private String oriRegNo;

    private String creditCode;

    private String frName;

    private BigDecimal regCap;

    private String regCapCur;

    private BigDecimal recCap;

    private String recCapCur;

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

    private Date createdAt;

    private String creator;

    private Date updatedAt;

    private String updater;

    private Short isDelete;
}