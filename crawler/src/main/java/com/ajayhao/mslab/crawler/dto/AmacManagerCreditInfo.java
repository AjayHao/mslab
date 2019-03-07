package com.ajayhao.mslab.crawler.dto;

import com.ajayhao.mslab.core.util.JsonUtil;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * AmacManagerCreditInfo
 *
 * @author Ajay Hao
 * @version 1.0
 * 协会管理人诚信信息
 * @date 2018/8/20 17:40
 **/
@Setter
@Getter
public class AmacManagerCreditInfo implements Serializable {
    private static final long serialVersionUID = 1L;

    private String id;

    private String registerNo;

    private String creditType;

    private String creditInfo;

    private String pullDate;


    @Override
    public String toString(){
        return JsonUtil.toJson(this);
    }
}
