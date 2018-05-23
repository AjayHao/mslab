package com.ajayhao.simpleboot.common.exception;

/**
 * <P>系统异常<P>
 * @author haozhenjie
 * @version $Id: BusinessSysException.java, v 0.1 2018年4月17日 下午5:08:43 AjayHao Exp $
 */
public class BusinessSysException extends RuntimeException {
    private static final long serialVersionUID = 422786219115052124L;

    public BusinessSysException() {
        super();
    }

    public BusinessSysException(String message) {
        super(message);
    }

    public BusinessSysException(String message, Throwable throwable) {
        super(message, throwable);
    }

    public BusinessSysException(Throwable throwable) {
        super(throwable);
    }
}
