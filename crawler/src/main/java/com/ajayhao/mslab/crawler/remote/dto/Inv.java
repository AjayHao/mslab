package com.ajayhao.mslab.crawler.remote.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @ClassName Inv
 * @Description Inv
 * @Author Ajay Hao
 * @Date 2018/7/2 1:23
 * @Version 1.0
 **/
@Setter
@Getter
public class Inv implements Serializable{
    private static final long serialVersionUID = 1L;

    @JsonProperty(value = "CERTYPE")
    private String certype;

    @JsonProperty(value = "FINALRATIO")
    private String finalRatio;

    @JsonProperty(value = "FINALSUBCONAM")
    private String finalSubcOnam;

    @JsonProperty(value = "FINALACCONAM")
    private String finalAccOnam;

    @JsonProperty(value = "IDCARD")
    private String idCard;

    @JsonProperty(value = "RATIOROAD")
    private String ratioRoad;

    @JsonProperty(value = "FINALENTNAME")
    private String finalEntName;

    @JsonProperty(value = "ADDRESS")
    private String address;

    @JsonProperty(value = "POSITION")
    private String position;

    @JsonProperty(value = "CAPITALCHAIN")
    private String capitalChain;
}
