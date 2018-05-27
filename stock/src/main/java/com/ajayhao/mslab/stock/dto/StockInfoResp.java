package com.ajayhao.mslab.stock.dto;

import com.ajayhao.mslab.core.common.BaseResp;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
public class StockInfoResp extends BaseResp {

    private static final long serialVersionUID = 1L;

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

}