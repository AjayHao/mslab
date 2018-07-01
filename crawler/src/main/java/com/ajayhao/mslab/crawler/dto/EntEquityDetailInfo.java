package com.ajayhao.mslab.crawler.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Setter
@Getter
public class EntEquityDetailInfo implements Serializable{

    private static final long serialVersionUID = 1L;

    private String entId;

    private String entName;

    private String pullDate;

    private String subjectType;

    private Integer traceLevel;

    private String nodeName;

    private String tags;

    private String conName;

    private BigDecimal conProp;

    private BigDecimal realConProp;

    private String position;

    private String idCard;

    private String cerType;

    private String address;

    private Date createdAt;

    private String creator;

    private Date modifiedAt;

    private String modifier;

    private Integer isDelete;

}