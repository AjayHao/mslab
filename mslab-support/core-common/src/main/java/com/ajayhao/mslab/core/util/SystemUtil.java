package com.ajayhao.mslab.core.util;

import com.ajayhao.mslab.core.common.exception.BusinessBizException;
import com.fasterxml.jackson.databind.ser.std.UUIDSerializer;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

import static com.ajayhao.mslab.core.common.enums.RespCodeType.PARSE_DATE_ERROR;
import static java.lang.Math.ceil;

/**
 * 类DateUtils.java的实现描述：<br/>
 * 系统工具类
 * 
 * @author haozhenjie 2018年5月8日 下午10:58:06
 */
@Slf4j
public class SystemUtil {

    /**
     * -
     */
    public final static String HYPHEN          = "-";

    public static String newUUID(){
        return UUID.randomUUID().toString().replaceAll(HYPHEN, "");
    }

}
