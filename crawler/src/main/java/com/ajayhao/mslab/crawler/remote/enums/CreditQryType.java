package com.ajayhao.mslab.crawler.remote.enums;

import com.ajayhao.mslab.core.common.IBaseEnum;
import com.ajayhao.mslab.core.util.EnumUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @ClassName CreditQryType
 * @Description EntId 查询类型字典
 * @Author Ajay Hao
 * @Date 2018/6/29 14:27
 * @Version 1.0
 **/
@Getter
@AllArgsConstructor
public enum CreditQryType implements IBaseEnum {

    CREDIT_CODE("1", "信用代码/注册号"),
    ENT_NAME("3", "全称");

    private final String code;
    private final String message;

    /**
     * Get yes no enum.
     *
     * @param code the code
     * @return the yes no enum
     */
    public static CreditQryType get(String code) {
        return EnumUtil.<CreditQryType> valueOf(CreditQryType.class, code);
    }
}
