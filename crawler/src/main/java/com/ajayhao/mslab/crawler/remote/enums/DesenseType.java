package com.ajayhao.mslab.crawler.remote.enums;

import com.ajayhao.mslab.core.common.IBaseEnum;
import com.ajayhao.mslab.core.util.EnumUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @ClassName DesenseType
 * @Description 脱敏类型
 * @Author Ajay Hao
 * @Date 2018/6/29 14:27
 * @Version 1.0
 **/
@Getter
@AllArgsConstructor
public enum DesenseType implements IBaseEnum {

    NONE("1", "不脱敏"),
    CER_TYPE("2", "身份信息脱敏"),
    CER_TYPE_AND_ADDR("3", "身份信息及地址脱敏");

    private final String code;
    private final String message;

    /**
     * Get yes no enum.
     *
     * @param code the code
     * @return the yes no enum
     */
    public static DesenseType get(String code) {
        return EnumUtil.<DesenseType> valueOf(DesenseType.class, code);
    }
}
