package com.ajayhao.simpleboot.remote.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by AjayHao on 2018/5/20.
 */
@Getter
@Setter
public class JuHeDapanDataDto implements Serializable{
    private static final long serialVersionUID = 1L;

    private BigDecimal dot;

    private String name;

    private BigDecimal nowPic;

    private BigDecimal rate;

    private BigDecimal traAmount;

    private BigDecimal traNumber;
}
