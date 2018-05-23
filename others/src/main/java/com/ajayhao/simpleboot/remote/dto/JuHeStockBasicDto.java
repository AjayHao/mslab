package com.ajayhao.simpleboot.remote.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by AjayHao on 2018/5/20.
 */

@Setter
@Getter
public class JuHeStockBasicDto implements Serializable{

    private static final long serialVersionUID = 1L;

    private BigDecimal buyFive;
    private BigDecimal buyFivePri;
    private BigDecimal buyFour;
    private BigDecimal buyFourPri;
    private BigDecimal buyThree;
    private BigDecimal buyThreePri;
    private BigDecimal buyTwo;
    private BigDecimal buyTwoPri;
    private BigDecimal buyOne;
    private BigDecimal buyOnePri;
    private BigDecimal competitivePri;
    private BigDecimal increPer;
    private BigDecimal increase;
    private BigDecimal nowPri;
    private BigDecimal reservePri;
    private BigDecimal sellFive;
    private BigDecimal sellFivePri;
    private BigDecimal sellFour;
    private BigDecimal sellFourPri;
    private BigDecimal sellThree;
    private BigDecimal sellThreePri;
    private BigDecimal sellTwo;
    private BigDecimal sellTwoPri;
    private BigDecimal sellOne;
    private BigDecimal sellOnePri;
    private BigDecimal todayMax;
    private BigDecimal todayMin;
    private BigDecimal todayStartPri;
    private BigDecimal traAmount;
    private BigDecimal traNumber;
    private BigDecimal yestodEndPri;
    private String date;
    private String time;
    private String gid;
    private String name;
}
