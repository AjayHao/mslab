package com.ajayhao.mslab.crawler.enums;

import com.ajayhao.mslab.core.common.IBaseEnum;
import com.ajayhao.mslab.core.util.EnumUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @ClassName ElsaicQryVersion
 * @Description 工商信息 查询类型字典
 * @Author Ajay Hao
 * @Date 2018/6/29 14:27
 * @Version 1.0
 **/
@Getter
@AllArgsConstructor
public enum GsInfoQryType implements IBaseEnum {

    BY_ID("1", "通过entid"),
    BY_NAME("2", "通过全称"),
    ;

    private final String code;
    private final String message;

    /**
     * Get yes no enum.
     *
     * @param code the code
     * @return the yes no enum
     */
    public static GsInfoQryType get(String code) {
        return EnumUtil.<GsInfoQryType> valueOf(GsInfoQryType.class, code);
    }
}
