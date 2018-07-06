package com.ajayhao.mslab.crawler.enums;

import com.ajayhao.mslab.core.common.IBaseEnum;
import com.ajayhao.mslab.core.util.EnumUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @ClassName EntParamType
 * @Description 数据操作类型字典
 * @Author Ajay Hao
 * @Date 2018/6/29 14:27
 * @Version 1.0
 **/
@Getter
@AllArgsConstructor
public enum EntParamType implements IBaseEnum {

    BY_ENT_ID("1", "通过企业id(entid)"),
    BY_CREDIT_CODE("2", "通过统一社会信用编码/注册号"),
    BY_NAME("3", "通过全称"),
    ;

    private final String code;
    private final String message;

    /**
     * Get yes no enum.
     *
     * @param code the code
     * @return the yes no enum
     */
    public static EntParamType get(String code) {
        return EnumUtil.<EntParamType> valueOf(EntParamType.class, code);
    }
}
