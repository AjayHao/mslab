package com.ajayhao.mslab.antxchecker.common.exception;


import com.ajayhao.mslab.antxchecker.common.BaseResultType;

/**
 * <P><P>
 * @author haozhenjie
 * @version $Id: BusinessBizException.java
 */
public class BusinessBizException extends RuntimeException {

    private static final long    serialVersionUID = 1L;

    private final BaseResultType type;

    /**
     * BusinessException
     *
     * @param type
     * @param args
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
     * 
     * <P> <P>
     * @return
     */
    public String getMsg() {
        return type.getMessage();
    }

    /**
     * 
     * <P> <P>
     * @return
     */
    public BaseResultType getType() {
        return type;
    }
}
