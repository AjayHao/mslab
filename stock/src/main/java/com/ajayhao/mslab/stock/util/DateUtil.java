package com.ajayhao.mslab.stock.util;

import com.ajayhao.mslab.stock.common.enums.RespCodeType;
import com.ajayhao.mslab.stock.common.exception.BusinessBizException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import static java.lang.Math.ceil;

/**
 * 类DateUtils.java的实现描述：<br/>
 * 时间工具类
 * 
 * @author haozhenjie 2018年5月8日 下午10:58:06
 */
@Slf4j
public class DateUtil {

    /**
     * DATE_FORMAT_YYYYMMDD
     */
    public final static String DATE_FORMAT_YYYYMMDD          = "yyyyMMdd";

    /**
     * DATE_FORMAT_YYYY_MM_DD
     */
    public final static String DATE_FORMAT_YYYY_MM_DD        = "yyyy-MM-dd";

    /**
     * DATE_FORMAT_YYYYMMDDHHMMSS
     */
    public final static String DATE_FORMAT_YYYYMMDDHHMMSS    = "yyyyMMddHHmmss";

    /**
     * DATE_FORMAT_YYYYMMDD_HHMMSS
     */
    public final static String DATE_FORMAT_YYYYMMDD_HHMMSS   = "yyyy-MM-dd HH:mm:ss";
    /**
     * DATE_FORMAT_yyyyMMddHHmmssSSS
     */
    public final static String DATE_FORMAT_yyyyMMddHHmmssSSS = "yyyyMMddHHmmssSSS";

    /**
     * DATE_FORMAT_yyyy-MM-dd'T'HH:mm:ss.sss'+08:00'
     */
    public final static String LOG_SPECIMAL_FORMAT           = "yyyy-MM-dd'T'HH:mm:ss.sss'+08:00'";
    
    /**
     * 年月日
     */
    public final static String DATE_FORMAT_YYYY_MM_DD_CHINA   = "yyyy年MM月dd日";
    
    /**
     * 年月日时分秒的中文格式
     */
    public final static String DATE_FORMAT_YYYY_MM_DD_HHMMSS_CHINA   = "yyyy年MM月dd日 HH:mm:ss";

    /**
     * 将yyyy-MM-dd的字符串转换成Date
     * 
     * @param str 需要转换的字符串
     * @return 转换后的时间
     */
    public static Date parseDateByYYYY_MM_DD(String str) {
        try {
            return DateUtils.parseDate(str, DATE_FORMAT_YYYY_MM_DD);
        } catch (ParseException e) {
            throw new BusinessBizException(RespCodeType.PARSE_DATE_ERROR, e);
        }
    }

    /**
     * 将yyyyMMdd的字符串转换成Date
     * 
     * @param str 需要转换的字符串
     * @return 转换后的时间
     */
    public static Date parseDateByYYYYMMDD(String str) {
        try {
            return DateUtils.parseDate(str, DATE_FORMAT_YYYYMMDD);
        } catch (ParseException e) {
            throw new BusinessBizException(RespCodeType.PARSE_DATE_ERROR, e);
        }
    }

    /**
     * 将yyyyMMddHHmmss的字符串转换成Date
     * 
     * @param str 需要转换的字符串
     * @return 转换之后的时间
     */
    public static Date parseDateByYYYYMMDDHHmmss(String str) {
        try {
            return DateUtils.parseDate(str, DATE_FORMAT_YYYYMMDDHHMMSS);
        } catch (ParseException e) {
            throw new BusinessBizException(RespCodeType.PARSE_DATE_ERROR, e);
        }
    }

    /**
     * 将yyyy-MM-dd HH:mm:ss的字符串转换成Date
     * 
     * @param str 需要转换的字符串
     * @return 转换之后的时间
     */
    public static Date parseDateByYYYYMMDD_HHmmss(String str) {
        try {
            return DateUtils.parseDate(str, DATE_FORMAT_YYYYMMDD_HHMMSS);
        } catch (ParseException e) {
            throw new BusinessBizException(RespCodeType.PARSE_DATE_ERROR, e);
        }

    }

    /**
     * 将Date转换成yyyyMMdd的字符串
     * 
     * @param date 需要转换的时间
     * @return 转换之后的时间字符串
     */
    public static String formatDateByYYYYMMDD(Date date) {
        return DateFormatUtils.format(date, DATE_FORMAT_YYYYMMDD);
    }

    /**
     * 将Date转换成yyyy-MM-dd的字符串
     * 
     * @param date 需要转换的时间
     * @return 转换之后的时间字符串
     */
    public static String formatDateByYYYY_MM_DD(Date date) {
        return DateFormatUtils.format(date, DATE_FORMAT_YYYY_MM_DD);
    }

    /**
     * 将Date转换成YYYYMMddHHmmss的字符串
     * 
     * @param date 需要转换的时间
     * @return 转换之后的时间字符串
     */
    public static String formatDateByYYYYMMddHHmmss(Date date) {
        return DateFormatUtils.format(date, DATE_FORMAT_YYYYMMDDHHMMSS);
    }

    /**
     * formatDateByYYYYMMddChina
     * 
     * @param date 需要转换的时间
     * @return 转换之后的时间字符串
     */
    public static String formatDateByYYYYMMddChina(Date date) {
        return DateFormatUtils.format(date, DATE_FORMAT_YYYY_MM_DD_CHINA);
    }
    
    /**
     * formatDateByYYYYMMddHHMMSSChina
     * 
     * @param date 需要转换的时间
     * @return 转换之后的时间字符串
     */
    public static String formatDateByYYYYMMddHHMMSSChina(Date date) {
        return DateFormatUtils.format(date, DATE_FORMAT_YYYY_MM_DD_HHMMSS_CHINA);
    }
    
    /**
     * 获取某一天中的开始时间
     * 
     * @param date
     * @return
     */
    public static Date toBeginDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.HOUR, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

    /**
     * 将Date转换成yyyy-MM-dd HH:mm:ss的字符串
     * 
     * @param date 需要转换的时间
     * @return 转换之后的时间字符串
     */
    public static String formatDateByYYYYMMdd_HHmmss(Date date) {
        return DateFormatUtils.format(date, DATE_FORMAT_YYYYMMDD_HHMMSS);
    }

    /**
     * 将Date转换成yyyyMMddHHmmssSSS的字符串
     * 
     * @param date 需要转换的时间
     * @return 转换之后的时间字符串
     */
    public static String formatDateByYYYYMMddHHmmssSSS(Date date) {
        return DateFormatUtils.format(date, DATE_FORMAT_yyyyMMddHHmmssSSS);
    }

    /**
     * 时间转化
     * 
     * @param date 需要转换的时间字符串
     * @param pattern 时间格式字符串
     * @return 转换后的时间
     */
    public static Date parseDateByPattern(String date, String pattern) {
        try {
            return DateUtils.parseDate(date, pattern);
        } catch (ParseException e) {
            throw new BusinessBizException(RespCodeType.PARSE_DATE_ERROR, e);
        }
    }

    /**
     * 时间转化
     * 
     * @param date 需要转换的时间
     * @param pattern 时间格式字符串
     * @return 转换后的时间字符串
     */
    public static String formatDateByPattern(Date date, String pattern) {
        return DateFormatUtils.format(date, pattern);
    }

    /**
     * 判断字符串是否是yyyy-MM-dd HH:mm:ss格式
     * 
     * @param str 需要判断的字符串
     * @return boolean
     */
    public static boolean isValidByYYYYMMdd_HHmmss(String str) {
        try {
            DateUtils.parseDateStrictly(str, DATE_FORMAT_YYYYMMDD_HHMMSS);
        } catch (ParseException e) {
            log.error("parse time exception:{}", e);
            return false;
        }
        return true;
    }

    /**
     * 判断字符串是否是yyyy-MM-dd格式
     * 
     * @param str 需要判断的字符串
     * @return boolean
     */
    public static boolean isValidByYYYY_MM_DD(String str) {
        try {
            DateUtils.parseDateStrictly(str, DATE_FORMAT_YYYY_MM_DD);
        } catch (ParseException e) {
            log.error("parse time exception:{}", e);
            return false;
        }
        return true;
    }

    /**
     * 判断字符串是否是yyyy-MM-dd格式
     * 
     * @param str
     * @param pattern 时间格式字符串
     * @return boolean
     */
    public static boolean isValidByPattern(String str, String pattern) {
        try {
            DateUtils.parseDateStrictly(str, pattern);
        } catch (ParseException e) {
            log.error("parse time exception:{}", e);
            return false;
        }
        return true;
    }

    /**
     * 加减day 返回日期
     * 
     * @param day 天数
     * @return
     */
    public static Date getDateChangeDay(Integer day) {
        Calendar c = Calendar.getInstance();
        c.add(Calendar.DATE, day);
        return c.getTime();
    }

    /**
     * 加减day 返回日期
     * 
     * @param srcDate 初始日期,day 天数
     * @return
     */
    public static Date getDateChangeDay(Date srcDate, Integer day) {
        Calendar c = Calendar.getInstance();
        c.setTime(srcDate);
        c.add(Calendar.DATE, day);
        return c.getTime();
    }

    /**
     * 加减minute 返回日期
     * 
     * @param minute 分
     * @return
     */
    public static Date getDateChangeMinute(Integer minute) {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.MINUTE, c.get(Calendar.MINUTE) + minute);
        return c.getTime();
    }

    /**
     * 计算两个日期相隔的天数（比较年月日）
     * 
     * @param date1 当前时期
     * @param date2 数据库字段日期
     * @return
     */
    public static int getDays(Date date1, Date date2) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
        String s1 = sdf.format(date1);
        String s2 = sdf.format(date2);
        /*
         * System.err.println(s1); System.err.println(s2);
         */

        s1 = s1.substring(0, 11);
        s2 = s2.substring(0, 11);
        /*
         * System.err.println("[" + s1 + "]"); System.err.println("[" + s2 +
         * "]");
         */
        s1 = s1 + "00-00-00";
        s2 = s2 + "00-00-00";

        try {
            Date d1 = sdf.parse(s1);
            Date d2 = sdf.parse(s2);

            long days = (d1.getTime() - d2.getTime()) / (1000 * 3600 * 24);
            return (int) days;
        } catch (ParseException e) {
            log.error("", e);
            return 999999;
        }
    }

    /**
     * 加减Hours 返回日期
     * 
     * @param hours 天数
     * @return
     */
    public static Date getDateChangeHours(Integer hours) {
        Calendar c = Calendar.getInstance();
        c.add(Calendar.HOUR, hours);
        return c.getTime();
    }

    /**
     * 获得当前月份的第一天
     * 
     * @return
     */
    public static Date getFirstDayOfCurrentMonth(String month) {
        Calendar c = Calendar.getInstance();
        c.setTime(parseDateByPattern(month, "yyyyMM"));
        c.set(Calendar.DAY_OF_MONTH, 1);
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        return c.getTime();
    }

    /**
     * 获得当前月份的最后一天
     * 
     * @return
     */
    public static Date getEndDayOfCurrentMonth(String month) {
        Calendar c = Calendar.getInstance();
        c.setTime(parseDateByPattern(month, "yyyyMM"));
        c.set(Calendar.DAY_OF_MONTH, c.getActualMaximum(Calendar.DAY_OF_MONTH));
        c.set(Calendar.HOUR_OF_DAY, 23);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        return c.getTime();
    }

    /**
     * 返回两个时间相差小时数
     * 
     * @param bDate
     * @param sDate
     * @return
     */
    public static long getHoursBetween(Date bDate, Date sDate) {
        long diff = bDate.getTime() - sDate.getTime();
        return diff / (60 * 60 * 1000);
    }

    /**
     * 获取当前时间的前N分钟
     *
     * @param date
     * @param previousMinute
     * @return
     */
    public static Date getPreviousDateByMinute(Date date, int previousMinute) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MINUTE, previousMinute);
        return cal.getTime();
    }

    /**
     * 获取当日零点时分
     *
     * @return
     */
    public static String getPreviousDateZERO() {
        return formatDateByYYYY_MM_DD(new Date()) + " 00:00:00";
    }

    /**
     * 比较是否同天
     *
     * @param date1
     * @param date2
     * @return
     */
    public static boolean isSameDate(Date date1, Date date2) {
        boolean ret = false;
        if(date1 != null && date2 != null){
            return formatDateByYYYYMMDD(date1).equals(formatDateByYYYYMMDD(date2));
        }
        return ret;
    }

    /**
     * @param millis
     * @return
     */
    public static int getHourByMillis(final Long millis) {
        return Double.valueOf(ceil(millis.doubleValue() / 1000 / 60 / 60)).intValue();
    }

    /**
     * 获取某年最后一天日期
     * 
     * @param nowDate 年份
     * @return Date
     */
    public static Date getNextYearLast(Date nowDate) {
        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        
        calendar.setTime(nowDate);
        int year = calendar.get(Calendar.YEAR);
        
        calendar.clear();
        calendar.set(Calendar.YEAR, year + 1);
        calendar.roll(Calendar.DAY_OF_YEAR, -1);
        Date currYearLast = calendar.getTime();

        return currYearLast;
    }

    /**
     * 获取当天日期(yyyyMM)
     *
     * @return
     */
    public static String getTodayFormatYYYYMM() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
        return sdf.format(new Date());
    }

    /**
     * 获取当前时间(yyyy-MM-dd HH:mm:ss)
     *
     * @return
     */
    public static String getTodayFormatYYYYMMDDHHMMSS() {
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_YYYYMMDD_HHMMSS);
        return sdf.format(new Date());
    }

    /**
     * 方法说明 （创建于 2014-6-17）. 描述：根据day日期进行加法计算
     *
     * @param date
     * @param day
     * @return
     * @returnType Date
     */
    public static Date addDate(Date date, int day) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.DAY_OF_MONTH, day);
        return c.getTime();
    }
}
