package com.ajayhao.simpleboot.remote.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * Created by AjayHao on 2018/5/21.
 */
@Setter
@Getter
public class JuHeReq implements Serializable{
    private static final long serialVersionUID = 1L;

    private String key;
}
