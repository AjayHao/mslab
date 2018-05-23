
package com.ajayhao.mslab.antxchecker.common.enums;

import com.ajayhao.mslab.antxchecker.common.BaseResultType;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 
 * <P> 响应code <P>
 * @author AjayHao
 * @version $Id: RespCodeType.java, v 0.1 2018年4月17日 下午4:35:19 AjayHao Exp $
 */
@Getter
@AllArgsConstructor
public enum RespCodeType implements BaseResultType {

    SUCCESS("0000", "业务成功"),

    //0000-0099 公共错误返回码
    PARAM_EMPTY("0002", "参数为空"),
    PARAM_ILLEGAL("0003", "参数不符合规范：{0}"),
    PARAM_ILLEGAL_OTHER("0004", "{0}"),
    PARSE_DATE_ERROR("0005", "解析时间错误，{0}"),
    INVALID_OPERATION("0006", "非法操作: {0}, {1}"),
    FCP_CONFIG_NOT_FOUND("0007", "数据库配置项缺失: {0}"),
    DB_OPERATION_FAIL("0008", "数据库操作失败: {0}"),
    ORDER_IDEMPOTENT("0009", "订单幂等"),
    FETCH_LOCK_ERROR("0010", "获取锁对象失败"),

    //0050-0099 远程外部调用
    REMOTE_INVOKE_ERROR("0099","远程调用异常"),

    //0100-0999 内部异常信息
    WRONG_STATUS_TRANSITION("0100","错误的状态迁移终态"),

    // 9000-9999 失败相关
    FAIL("9000", "业务处理失败"),
    DB_ERROR("9991", "数据库写入异常,{0}"),
    SYSTEM_ERROR_OTHER("9997", "系统异常,{0}"),
    SYSTEM_ERROR("9998", "系统异常"),
    UN_KNOWN_ERROR("9999", "未知异常,{0}"),
    UN_KNOWN("9999", "未知异常"),

    ;

    private final String code;
    private final String message;

    /**
     * get enum
     * 
     * @param code
     * @return
     */
    public static RespCodeType getRespCodeType(String code) {
        for (RespCodeType type : RespCodeType.values()) {
            if (type.getCode().equals(code)) {
                return type;
            }
        }
        return null;
    }

    /**
     * get enum
     * 
     * @param codeType
     * @return
     */
    public static RespCodeType parse(RespCodeType codeType) {
        if (codeType == null) {
            return RespCodeType.FAIL;
        }
        return codeType;
    }
}
