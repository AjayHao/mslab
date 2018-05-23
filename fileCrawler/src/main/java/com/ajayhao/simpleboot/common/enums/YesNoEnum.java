package com.ajayhao.simpleboot.common.enums;


import com.ajayhao.simpleboot.common.BaseResultType;
import com.ajayhao.simpleboot.util.EnumUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * <P><P>
 * @author AjayHao
 * @version $Id: YesNoEnum.java, v 0.1 2018年4月19日 下午1:53:03 AjayHao Exp $
 */
@Getter
@AllArgsConstructor
public enum YesNoEnum implements BaseResultType {

    Y("Y", "YES"),
    N("N", "NO");

    private final String code;
    private final String message;
    
    /**
     * <P> <P>
     */
    public static YesNoEnum get(String code) {
        return EnumUtil.<YesNoEnum> valueOf(YesNoEnum.class, code);
    }
}
