package com.ajayhao.mslab.antxchecker.remote.dto.response;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.io.Serializable;
import java.util.List;

/**
 * Created by AjayHao on 2018/5/20.
 */
@Setter
@Getter
public class JuHeRemoteResp<T> implements Serializable{

    private static final long serialVersionUID = 1L;

    private String resultcode;

    private String reason;

    private Integer error_code;

    private T result;

    public Boolean isSuccess(){
        return HttpStatus.OK.value() == Integer.parseInt(resultcode) && error_code.intValue() == 0;
    }

}
