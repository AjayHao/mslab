
package com.ajayhao.mslab.core.util;


import com.ajayhao.mslab.core.common.IBaseEnum;
import org.apache.commons.lang3.StringUtils;

/**
 * <P><P>
 * @author AjayHao
 * @version $Id: EnumUtil.java, v 0.1 2018年4月19日 下午6:04:51 AjayHao Exp $
 */
public final class EnumUtil {

    /**
     * <P> code转换枚举 <P>
     * @param enumClass
     * @param code
     * @return
     */
    public static <E extends IBaseEnum> E valueOf(Class<E> enumClass, String code) {
        if (enumClass != null && StringUtils.isNotBlank(code)){
            for (E e : enumClass.getEnumConstants()) {
                if (StringUtils.equals(code, e.getCode())) {
                    return e;
                }
            }
        }
        return null;
    }

    /**
     * <P> 获得code <P>
     * @param baseEnum
     * @return
     */
    public static String getCode(IBaseEnum baseEnum) {
        return baseEnum != null ? baseEnum.getCode() : null;
    }



}
