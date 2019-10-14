package com.ajayhao.mslab.core.common;


import com.ajayhao.mslab.core.common.enums.RespCodeType;
import com.ajayhao.mslab.core.util.JsonUtil;

import java.io.Serializable;

import static com.ajayhao.mslab.core.common.enums.RespCodeType.INVALID_PARAM;

/**
 * <p>
 * 错误码格式 状态标志1位-应用内错误码-应用代码
 * 状态标志: 0-成功  4-客户端错误(如客户端参数非法等)  5-服务端错误(如服务端内部调用出错)
 * 应用标志: 固定两位长度,每个应用唯一,编号从1开始
 * 应用内部错误码 :  应用内部的错误码,两位英文字符
 * </p>
 * Created by liming on 2017/7/7.
 */
public class Result<T> implements Serializable {
    /**
     * Result默认信息
     */
    private static final String DEFAULT_SUCCESS_MESSAGE = "成功";

    /**
     * Result错误码格式
     */
    public static final String CODE_FORMAT = "%d-%d-%s";
    private static final long serialVersionUID = 515730635420960456L;

    private String code;
    private String message;
    private String cause;
    private T data;
    private Object controlData;

    public String getCode() {
        return code;
    }

    public Result setCode(String code) {
        this.code = code;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public Result setMessage(String message) {
        this.message = message;
        return this;
    }

    public String getCause() {
        return cause;
    }

    public Result setCause(String cause) {
        this.cause = cause;
        return this;
    }

    public T getData() {
        return data;
    }

    public Result setData(T data) {
        this.data = data;
        return this;
    }

    public Object getControlData() {
        return controlData;
    }

    public void setControlData(Object controlData) {
        this.controlData = controlData;
    }

    @Override
    public String toString() {
        return JsonUtil.toJson(this);
    }

    /**
     * 成功
     *
     * @param data
     * @return
     */
    @SuppressWarnings({"unchecked","rawtypes"})
    public static Result genSuccessResult(Object data) {
        return new Result()
                .setCode("0")
                .setMessage(DEFAULT_SUCCESS_MESSAGE)
                .setData(data);
    }

    /**
     * 客户端非法参数 请求错误
     * 需要客户端也只能客户端做处理后再重新提交 例如后台校验到参数存在错误的情况
     * 不需要返回堆栈错误的情况
     * @param appId 应用ID
     * @param code 错误码
     * @param message 给用户看的信息
     * @return
     */
    public static Result genInvalidParamResult(String message) {
        return new Result()
                .setCode(INVALID_PARAM.getCode())
                .setMessage(message);
    }

    /**
     * 客户端请求错误
     * 需要客户端也只能客户端做处理后再重新提交 例如后台校验到参数存在错误的情况
     * @param appId 应用名
     * @param errorCodeType
     * @param cause 给开发看的信息
     * @return
     */
    public static Result genFailResult(RespCodeType errorCodeType, String cause) {
        return new Result()
                .setCode(errorCodeType.getCode())
                .setMessage(errorCodeType.getMessage())
                .setCause(cause);
    }

    /**
     * 判定是否成功
     * @param result
     * @return
     */
    public static Boolean isSuccess(Result result){
        return null != result && "0".equals(result.getCode());
    }


}
