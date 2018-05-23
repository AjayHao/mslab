package com.ajayhao.mslab.antxchecker.common;

import java.io.Serializable;

/**
 * <P>枚举基类<P>
 * @author AjayHao
 * @version $Id: BaseEnum.java, v 0.1 2018年4月17日 下午8:13:13 AjayHao Exp $
 */
public interface IBaseEnum extends Serializable {

    /**
     * <P>getCode <P>
     * @return
     */
    String getCode();

    /**
     * <P>getMessage <P>
     * @return
     */
    String getMessage();
    
}
