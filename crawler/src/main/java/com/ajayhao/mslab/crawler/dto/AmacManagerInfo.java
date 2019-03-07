package com.ajayhao.mslab.crawler.dto;

import com.ajayhao.mslab.core.util.JsonUtil;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * AmacManagerInfo
 *
 * @author Ajay Hao
 * @version 1.0
 * 协会管理人信息
 * @date 2018/7/18 17:40
 **/
@Setter
@Getter
public class AmacManagerInfo implements Serializable {
    private static final long serialVersionUID = 1L;

    private String id;

    private String registerNo;

    private String orgNo;

    private String creditCode;

    private String entId;

    private String managerName;

    private String managerNameEn;

    private String pullDate;

    private String url;

    private String frName;

    private String registerDate;

    private String establishDate;

    private String registerAddress;

    private String officeAddress;

    private String investType;

    private Integer fundCount;

    private BigDecimal fundScale;

    private BigDecimal subscribedCapital;

    private BigDecimal paidInCapital;

    private BigDecimal subscribeRatio;

    private String entType;

    private Integer employeeNum;

    private String integrityInfo;

    private String registerProvince;

    private String registerCity;

    private String regCoordinate;

    private String officeProvince;

    private String officeCity;

    private String officeCoordinate;

    /**
     * 是否会员
     */
    private String memberFlag;

    /**
     * 会员类型
     */
    private String memberType;

    /**
     * 入会时间
     */
    private String memberDate;

    private List<AmacExecutiveInfo> executiveInfo;

    private List<AmacManagerCreditInfo> creditInfo;

    @Override
    public String toString(){
        return JsonUtil.toJson(this);
    }
}
