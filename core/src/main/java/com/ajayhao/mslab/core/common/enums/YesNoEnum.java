package com.ajayhao.mslab.core.common.enums;

import com.ajayhao.mslab.core.common.BaseResultType;
import com.ajayhao.mslab.core.util.EnumUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @EnumName YesNoEnum
 * @Description YesNoEnum
 * @Author Ajay Hao
 * @Date 2018.05.23
 * @Version 1.0
 */
@Getter
@AllArgsConstructor
public enum YesNoEnum implements BaseResultType {

    Y("Y", "YES"),
    N("N", "NO");

    private final String code;
    private final String message;

    /**
     * Get yes no enum.
     *
     * @param code the code
     * @return the yes no enum
     */
    public static YesNoEnum get(String code) {
        return EnumUtil.<YesNoEnum> valueOf(YesNoEnum.class, code);
    }
}
