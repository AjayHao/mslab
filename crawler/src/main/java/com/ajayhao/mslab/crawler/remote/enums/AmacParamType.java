package com.ajayhao.mslab.crawler.remote.enums;

import com.ajayhao.mslab.core.common.IBaseEnum;
import com.ajayhao.mslab.core.util.EnumUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * AmacParamType
 * 数据操作类型字典
 * @author Ajay Hao
 * @date 2018/7/29 14:27
 * @version 1.0
 **/
@Getter
@AllArgsConstructor
public enum AmacParamType implements IBaseEnum {
    /**
     * 通过协会注册编码
     */
    BY_REG_NO("1", "协会注册编码(P码)"),
    /**
     * 通过组织机构代码
     */
    BY_ORG_NO("2", "组织机构代码"),
    /**
     * 通过企业全称
     */
    BY_NAME("3", "企业全称"),
    ;

    private final String code;
    private final String message;

    /**
     * Get yes no enum.
     *
     * @param code the code
     * @return the yes no enum
     */
    public static AmacParamType get(String code) {
        return EnumUtil.<AmacParamType> valueOf(AmacParamType.class, code);
    }
}
