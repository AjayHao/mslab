package com.ajayhao.simpleboot.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * Created by AjayHao on 2018/5/21.
 */

@Setter
@Getter
public class StockInfoReq implements Serializable{
    private static final long serialVersionUID = 1L;

    private String gid;

    private Integer type;
}
