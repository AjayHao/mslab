package com.ajayhao.mslab.antxchecker.dto;

import com.ajayhao.mslab.core.common.enums.RespCodeType;

import java.io.Serializable;
import java.util.List;

/**
 * Created by AjayHao on 2017/9/10.
 */
public class AntxCheckerResponse implements Serializable{

    private static final long serialVersionUID = -4666440020213944022L;

    private RespCodeType bizCode;

    private String message;

    private List<AntxCheckDetail> details;

    public AntxCheckerResponse(){
        this.bizCode = RespCodeType.SUCCESS;
    }

    public AntxCheckerResponse(RespCodeType bizCode){
        this.bizCode = bizCode;
    }

    public AntxCheckerResponse(RespCodeType bizCode, String message){
        this.bizCode = bizCode;
        this.message = message;
    }

    public RespCodeType getBizCode() {
        return bizCode;
    }

    public void setBizCode(RespCodeType bizCode) {
        this.bizCode = bizCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<AntxCheckDetail> getDetails() {
        return details;
    }

    public void setDetails(List<AntxCheckDetail> details) {
        this.details = details;
    }
}
