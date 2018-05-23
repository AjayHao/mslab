package com.ajayhao.mslab.stock.common.exception;

/**
 * @ClassName BusinessSysException
 * @Description BusinessSysException
 * @Author Ajay Hao
 * @Date 2018.05.23
 * @Version 1.0
 */
public class BusinessSysException extends RuntimeException {
    private static final long serialVersionUID = 422786219115052124L;

    /**
     * Instantiates a new Business sys exception.
     */
    public BusinessSysException() {
        super();
    }

    /**
     * Instantiates a new Business sys exception.
     *
     * @param message the message
     */
    public BusinessSysException(String message) {
        super(message);
    }

    /**
     * Instantiates a new Business sys exception.
     *
     * @param message   the message
     * @param throwable the throwable
     */
    public BusinessSysException(String message, Throwable throwable) {
        super(message, throwable);
    }

    /**
     * Instantiates a new Business sys exception.
     *
     * @param throwable the throwable
     */
    public BusinessSysException(Throwable throwable) {
        super(throwable);
    }
}
