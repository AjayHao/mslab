package com.ajayhao.mslab.core.common;

import com.ajayhao.mslab.core.common.enums.RespCodeType;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.io.Serializable;
import java.util.Date;

import static com.ajayhao.mslab.core.common.LabConstant.SHARE_DEFAULT_FORMAT;
import static com.ajayhao.mslab.core.common.enums.RespCodeType.*;

/**
 * <P>基础Resp<P>
 * @author haozhenjie
 * @version $Id: BaseResp.java, v 0.1 2018年4月17日 下午4:16:57
 */

@AllArgsConstructor
@NoArgsConstructor
public class BaseResp<E> implements Serializable {

    /**  **/
    private static final long serialVersionUID = -5027854375055011927L;

    /** 响应时间 **/
    @JsonFormat(pattern = SHARE_DEFAULT_FORMAT, timezone = "GMT+8")
    private Date              respDate         = new Date();

    /** 响应CODE **/
    private String            respCode;

    /** 响应信息 **/
    private String            respMsg;


    private E                 data;


    public BaseResp setRespCode(String respCode) {
        this.respCode = respCode;
        return this;
    }

    public BaseResp setRespMsg(String respMsg) {
        this.respMsg = respMsg;
        return this;
    }

    public BaseResp setData(E data) {
        this.data = data;
        return this;
    }

    /**
     * <P> 初始化成功 无参数<P>
     */
    public static BaseResp buildSuccess() {
        return BaseResp.buildSuccess(null);
    }

    /**
     * <P> 初始化成功 带参<P>
     */
    public static BaseResp buildSuccess(Object data) {
        return new BaseResp().setRespCode(SUCCESS.getCode())
                .setRespMsg(SUCCESS.getMessage())
                .setData(data);
    }

    /**
     * <P> 初始化失败 <P>
     */
    public static BaseResp buildFail() {
        return new BaseResp().setRespCode(FAIL.getCode())
                .setRespMsg(FAIL.getMessage());
    }

    public static BaseResp buildFail(RespCodeType respCodeType, String respMsg) {
        return new BaseResp().setRespCode(respCodeType.getCode())
                .setRespMsg(respCodeType.getMessage());
    }

    /**
     * <P> 初始化幂等 <P>
     */
    public static BaseResp buildIdempotent() {
        return new BaseResp().setRespCode(ORDER_IDEMPOTENT.getCode())
                .setRespMsg(ORDER_IDEMPOTENT.getMessage());
    }

    /**
     * <P> 是否成功,只代表请求成功 <P>
     * @return
     */
    public boolean isSuccess() {
        return getRespCodeType(respCode) == SUCCESS;
    }

    /**
     * <P> 是否幂等 <P>
     * @return
     */
    public boolean isIdempotent() {
        return getRespCodeType(respCode) == ORDER_IDEMPOTENT;
    }

    public E getData() {
        return data;
    }
}
