package com.ajayhao.simpleboot.dto.antxchecker;

import com.ajayhao.core.enumtype.BizCode;

import java.io.Serializable;
import java.util.List;

/**
 * Created by AjayHao on 2017/9/10.
 */
public class AntxCheckerResponse implements Serializable{

    private static final long serialVersionUID = -4666440020213944022L;

    private BizCode bizCode;

    private String message;

    private List<AntxCheckDetail> details;

    public AntxCheckerResponse(){
        this.bizCode = BizCode.SUCCESS;
    }

    public AntxCheckerResponse(BizCode bizCode){
        this.bizCode = bizCode;
    }

    public AntxCheckerResponse(BizCode bizCode, String message){
        this.bizCode = bizCode;
        this.message = message;
    }

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

    public List<AntxCheckDetail> getDetails() {
        return details;
    }

    public void setDetails(List<AntxCheckDetail> details) {
        this.details = details;
    }
}
