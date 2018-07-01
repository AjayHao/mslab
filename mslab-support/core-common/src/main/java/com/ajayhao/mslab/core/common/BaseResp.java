package com.ajayhao.mslab.core.common;

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
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class BaseResp implements Serializable {

    /**  **/
    private static final long serialVersionUID = -5027854375055011927L;

    /** 响应时间 **/
    @JsonFormat(pattern = SHARE_DEFAULT_FORMAT, timezone = "GMT+8")
    private Date              respDate         = new Date();

    /** 响应CODE **/
    private String            respCode;

    /** 响应信息 **/
    private String            respMsg;


    /**
     * <P> 初始化成功 <P>
     */
    @SuppressWarnings("unchecked")
    public <T extends BaseResp> T buildSuccess() {
        respCode = SUCCESS.getCode();
        respMsg = SUCCESS.getMessage();
        return (T) this;
    }

    /**
     * <P> 初始化失败 <P>
     */
    @SuppressWarnings("unchecked")
    public <T extends BaseResp> T buildFail() {
        respCode = FAIL.getCode();
        respMsg = FAIL.getMessage();
        return (T) this;
    }

    /**
     * <P> 初始化幂等 <P>
     */
    @SuppressWarnings("unchecked")
    public <T extends BaseResp> T buildIdempotent() {
        respCode = ORDER_IDEMPOTENT.getCode();
        respMsg = ORDER_IDEMPOTENT.getMessage();
        return (T) this;
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

    /**
     * 
     * <P> <P>
     * @param respCode
     * @param respMsg
     * @return
     */
    public static BaseResp of(String respCode, String respMsg) {
        return new BaseResp(new Date(), respCode, respMsg);
    }

    /**
     * 
     * <P> <P>
     * @param resultType
     * @return
     */
    public static BaseResp of(BaseResultType resultType) {
        return new BaseResp(new Date(), resultType.getCode(), resultType.getMessage());
    }

}
