package com.ajayhao.mslab.crawler.remote.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * @ClassName InvRoad
 * @Description InvRoad
 * @Author Ajay Hao
 * @Date 2018/7/2 1:35
 * @Version 1.0
 **/

@Setter
@Getter
public class InvRoad implements Serializable {
    private static final long serialVersionUID = 1L;

    private String name;

    private Integer tags;

    private BigDecimal conprop;

    @JsonProperty(value = "real_conprop")
    private BigDecimal realConprop;

    private String position;

    private String idcard;

    private String certype;

    private String address;

    private List<InvRoad> children;
}
