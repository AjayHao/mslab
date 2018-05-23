package com.ajayhao.simpleboot.remote.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * Created by AjayHao on 2018/5/20.
 */
@Setter
@Getter
public class JuHeStockDto implements Serializable{
    private static final long serialVersionUID = 1L;

    private JuHeStockBasicDto data;

    private JuHeDapanDataDto dapandata;

    private JuHeGoPictureDto gopicture;

}
