package com.ajayhao.mslab.crawler.orm.entity;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
public class EntEquityDetailEntity extends BaseEntDataEntity{

    private String subjectType;

    private Integer traceLevel;

    private String nodeId;

    private String parentNodeId;

    private String nodeName;

    private String tags;

    private String conName;

    private BigDecimal conProp;

    private BigDecimal realConProp;

    private String position;

    private String idCard;

    private String cerType;

    private String address;

}