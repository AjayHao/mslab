package com.ajayhao.mslab.crawler.orm.entity;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
public class EntControlEntity extends BaseEntDataEntity {

    private String subjectType;

    private String idCard;

    private String cerType;

    private String finalEntName;

    private String address;

    private BigDecimal finalRatio;

    private BigDecimal finalSubsNum;

    private BigDecimal finalAccNum;

    private String ratioRoad;

    private String position;

    private String capitalChain;

}