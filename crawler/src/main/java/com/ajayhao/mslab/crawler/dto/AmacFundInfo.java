package com.ajayhao.mslab.crawler.dto;


import com.ajayhao.mslab.core.util.JsonUtil;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * AmacFundInfo
 *
 * @author Ajay Hao
 * @version 1.0
 * 协会私募基金信息
 * @date 2018/7/30 17:40
 **/
@Setter
@Getter
public class AmacFundInfo implements Serializable {
    private static final long serialVersionUID = 1L;

    private String id;

    private String pullDate;

    private String fundNo;

    private String fundName;

    /**
     * 管理人注册代码
     */
    private String managerRegNo;

    private String managerName;

    private String managerType;

    private String workingState;

    private String url;

    private String putOnRecordDate;

    private String isDeputeManage;

    private String establishDate;

    private String mandatorName;

    private String putOnRecordStage;

    private String fundType;

    private String latestUpdateDate;

    private String specialTips;

    @Override
    public String toString(){
        return JsonUtil.toJson(this);
    }
}
