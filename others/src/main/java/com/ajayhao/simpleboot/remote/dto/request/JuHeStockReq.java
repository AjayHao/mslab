package com.ajayhao.simpleboot.remote.dto.request;

import lombok.*;

/**
 * Created by AjayHao on 2018/5/21.
 */
@Setter
@Getter
public class JuHeStockReq extends JuHeReq{

    private static final long serialVersionUID = 1L;

    private String gid;

    private Integer type;
}
