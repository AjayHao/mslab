package com.ajayhao.simpleboot.common.exception;


import com.ajayhao.simpleboot.common.BaseResultType;

import java.text.MessageFormat;

/**
 * 
 * <P><P>
 * @author haozhenjie
 * @version $Id: MessageBundle.java
 */
public class MessageBundle {

    /**
     * getString
     *
     * @param type
     * @param args
     * @return
     */
    public static String getString(BaseResultType type, Object... args) {
        return MessageFormat.format(type.getMessage(), args);
    }
}
