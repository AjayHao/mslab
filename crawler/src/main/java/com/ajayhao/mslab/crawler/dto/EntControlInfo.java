package com.ajayhao.mslab.crawler.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author AjayHao
 */
@Setter
@Getter
public class EntControlInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    private String entId;

    private String entName;

    private String pullDate;

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

    private Long createdAt;

    private String creator;

    private Long updatedAt;

    private String updater;

    private String isDelete;

}