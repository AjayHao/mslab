package com.ajayhao.mslab.crawler.remote.enums;

import com.ajayhao.mslab.core.common.IBaseEnum;
import com.ajayhao.mslab.core.util.EnumUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

/**
 * AmacCreditInfoType
 * 机构诚信类型字典
 * @author Ajay Hao
 * @date 2018/7/29 14:27
 * @version 1.0
 **/
@Getter
@AllArgsConstructor
public enum AmacCreditInfoType implements IBaseEnum {
    /**
     * 失联机构
     */
    LOST_CONTACT("isLostContactMechanism", "失联机构"),
    /**
     * 异常机构
     */
    IDENTIFICATION("identification", "异常机构"),
    /**
     * 虚假填报
     */
    SHAM_STATEMENT("shamStatement", "虚假填报"),
    /**
     * 重大遗漏
     */
    OMISSION("materRialOmission", "重大遗漏"),
    /**
     * 违反八条底线
     */
    EIGHT_LINE("eightLine", "违反八条底线"),
    /**
     * 相关主体存在不良诚信记录
     */
    BAD_CREDIT("badCredit", "相关主体存在不良诚信记录"),
    /**
     * 相关主体存在不良诚信记录
     */
    ADMIN_SUPERVISION("adminSupervision", "行政监管措施"),
    /**
     * 其他诚信信息
     */
    OTHERS("others", "其他诚信信息"),
    ;

    private final String code;
    private final String message;

    /**
     * Get yes no enum.
     *
     * @param code the code
     * @return the yes no enum
     */
    public static AmacCreditInfoType get(String code) {
        return EnumUtil.<AmacCreditInfoType> valueOf(AmacCreditInfoType.class, code);
    }


    public static AmacCreditInfoType getByMessage(String name) {
        for(AmacCreditInfoType creditInfoType : values()){
            if(StringUtils.equals(creditInfoType.getMessage(), name)){
                return creditInfoType;
            }
        }

        return null;
    }
}
