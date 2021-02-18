package com.ajayhao.mslab.stock.orm.entity;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Setter
@Getter
public class StockInfoDO {

    private Long id;

    private String gid;

    private String workDate;

    private String stockName;

    private BigDecimal increPer;

    private BigDecimal increase;

    private BigDecimal todayStartPri;

    private BigDecimal yestodEndPri;

    private BigDecimal nowPri;

    private BigDecimal todayMax;

    private BigDecimal todayMin;

    private BigDecimal traNumber;

    private BigDecimal traAmount;

    private Date gmtCreated;

    private String creator;

    private Date gmtModified;

    private String modifier;

    private String isDeleted;

}