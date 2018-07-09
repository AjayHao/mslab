package com.ajayhao.mslab.crawler.orm.entity;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
public class EntEquityDetailEntity extends BaseEntDataEntity{

    private String subjectType;

    private Short traceLevel;

    private String nodeName;

    private String tags;

    private String conName;

    private BigDecimal conProp;

    private BigDecimal realConProp;

    private String position;

    private String idCard;

    private String cerType;

    private String address;

    private String nodeId;

    private String parentNodeId;

    private BigDecimal regAmt;

}