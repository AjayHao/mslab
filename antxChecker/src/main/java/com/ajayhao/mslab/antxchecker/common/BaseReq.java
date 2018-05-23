package com.ajayhao.mslab.antxchecker.common;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * <P>基础req<P>
 * @author AjayHao
 * @version $Id: BaseReq.java, v 0.1 2018年4月17日 下午3:43:09 AjayHao Exp $
 */
@Getter
@Setter
@ToString(callSuper = true)
public class BaseReq implements Serializable {

    /**  **/
    private static final long serialVersionUID = -2134834794963478416L;

    /** 请求时间 **/
    @DateTimeFormat(pattern = LabConstant.SHARE_DEFAULT_FORMAT)
    private Date              reqDate;

    private String            reqNo;

    /** 请求IP **/
    private String            ip;

}
