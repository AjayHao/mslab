package com.ajayhao.mslab.crawler.remote.enums;

import com.ajayhao.mslab.core.common.IBaseEnum;
import com.ajayhao.mslab.core.util.EnumUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @ClassName ElsaicQryVersion
 * @Description 征信信息 查询类型字典
 * @Author Ajay Hao
 * @Date 2018/6/29 14:27
 * @Version 1.0
 **/
@Getter
@AllArgsConstructor
public enum ElsaicQryVersion implements IBaseEnum {

    BASIC("A1", "基本照面信息"),
    ALTER("A2", "变更信息"),
    SHAREHOLDER("B1", "股东信息"),
    FRINV("B4", "对外投资信息"),
    ;

    private final String code;
    private final String message;

    /**
     * Get yes no enum.
     *
     * @param code the code
     * @return the yes no enum
     */
    public static ElsaicQryVersion get(String code) {
        return EnumUtil.<ElsaicQryVersion> valueOf(ElsaicQryVersion.class, code);
    }
}
