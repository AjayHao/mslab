package com.ajayhao.mslab.antxchecker.dto;

import com.ajayhao.core.enumtype.BizCode;
import com.ajayhao.mslab.antxchecker.util.CoreObjectUtils;

import java.io.Serializable;

/**
 * Created by AjayHao on 2017/7/7.
 */
public class CommonResponse implements Serializable {

    private static final long serialVersionUID = -1283001560963011751L;

    public CommonResponse(){}

    public CommonResponse(BizCode bizCode){
        this.bizCode = bizCode;
    }

    public CommonResponse(BizCode bizCode, String message){
        this.bizCode = bizCode;
        this.message = message;
    }

    private BizCode bizCode;

    private String message;

    public BizCode getBizCode() {
        return bizCode;
    }

    public void setBizCode(BizCode bizCode) {
        this.bizCode = bizCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return CoreObjectUtils.object2Json(this);
    }
}
