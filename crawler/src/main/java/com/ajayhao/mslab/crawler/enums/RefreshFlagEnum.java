package com.ajayhao.mslab.crawler.enums;

import com.ajayhao.mslab.core.common.IBaseEnum;
import com.ajayhao.mslab.core.util.EnumUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @EnumName RefreshFlagEnum
 * @Description 数据更新方式
 * @Author Ajay Hao
 * @Date 2018.05.23
 * @Version 1.0
 */
@Getter
@AllArgsConstructor
public enum RefreshFlagEnum implements IBaseEnum {

    FULL("1", "全量同步"),
    INCRE("2", "增量同步");

    private final String code;
    private final String message;

    /**
     * Get yes no enum.
     *
     * @param code the code
     * @return the yes no enum
     */
    public static RefreshFlagEnum get(String code) {
        return EnumUtil.<RefreshFlagEnum> valueOf(RefreshFlagEnum.class, code);
    }
}
