package com.ajayhao.mslab.core.common.exception;

/**
 * @InterfaceName IErrorCodeType
 * @Description 错误类型接口，便于统一处理类型
 * @Author Ajay Hao
 * @Date 2018/7/10 20:52
 * @Version 1.0
 **/
public interface IErrorCodeType {

    /**
     * 返回代码
     * @return
     */
    int getCode();

    /**
     * 返回描述
     * @return
     */
    String getMessage();
}
