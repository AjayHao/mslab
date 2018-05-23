package com.ajayhao.mslab.core.common.exception;


import com.ajayhao.mslab.core.common.BaseResultType;

/**
 * @ClassName BusinessBizException
 * @Description BusinessBizException
 * @Author Ajay Hao
 * @Date 2018.05.23
 * @Version 1.0
 */
public class BusinessBizException extends RuntimeException {

    private static final long    serialVersionUID = 1L;

    private final BaseResultType type;

    /**
     * Instantiates a new Business biz exception.
     *
     * @param type the type
     * @param args the args
     */
    public BusinessBizException(BaseResultType type, Object... args) {
        super(MessageBundle.getString(type, args));
        this.type = type;
    }

    /**
     * Gets code.
     *
     * @return the code
     */
    public String getCode() {
        return type.getCode();
    }

    /**
     * Gets msg.
     *
     * @return the msg
     */
    public String getMsg() {
        return type.getMessage();
    }

    /**
     * Gets type.
     *
     * @return the type
     */
    public BaseResultType getType() {
        return type;
    }
}
