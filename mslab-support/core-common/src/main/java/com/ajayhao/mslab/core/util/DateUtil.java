package com.ajayhao.mslab.core.util;

import com.ajayhao.mslab.core.common.exception.BusinessSysException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.util.CollectionUtils;

import java.text.ParseException;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.time.temporal.TemporalField;
import java.time.temporal.WeekFields;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import static java.lang.Math.ceil;

/**
 * 类DateUtils.java的实现描述：<br/>
 * 时间工具类
 *
 * @author haozhenjie 2018年5月8日 下午10:58:06
 *                    2020年2月22日 将Calendar SimpleDateFormat改写为LocalDate, LocalDateTime及DateTimeFormatter
 */
@Slf4j
public class DateUtil {

    public final static String[] WEEK_DAYS = { "零", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六","星期日", };

    /**
     * DATE_FORMAT_YYYYMMDD
     */
    public final static String DATE_FORMAT_YYYYMMDD = "yyyyMMdd";

    /**
     * DATE_FORMAT_YYYY_MM_DD
     */
    public final static String DATE_FORMAT_YYYY_MM_DD = "yyyy-MM-dd";

    /**
     * DATE_FORMAT_YYYYMMDDHHMMSS
     */
    public final static String DATE_FORMAT_YYYYMMDDHHMMSS = "yyyyMMddHHmmss";

    /**
     * DATE_FORMAT_YYYYMMDD_HHMMSS
     */
    public final static String DATE_FORMAT_YYYYMMDD_HHMMSS = "yyyy-MM-dd HH:mm:ss";
    /**
     * DATE_FORMAT_yyyyMMddHHmmssSSS
     */
    public final static String DATE_FORMAT_yyyyMMddHHmmssSSS = "yyyyMMddHHmmssSSS";

    /**
     * DATE_FORMAT_yyyy-MM-dd'T'HH:mm:ss.sss'+08:00'
     */
    public final static String LOG_SPECIMAL_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.sss'+08:00'";

    /**
     * 年月日
     */
    public final static String DATE_FORMAT_YYYY_MM_DD_CHINA = "yyyy年MM月dd日";

    /**
     * 年月日时分秒的中文格式
     */
    public final static String DATE_FORMAT_YYYY_MM_DD_HHMMSS_CHINA = "yyyy年MM月dd日 HH:mm:ss";

    /**
     * DATE_FORMAT_HH:mm:ss
     */
    public final static String DATE_FORMAT_HHMMSS = "HH:mm:ss";

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
            throw new BusinessSysException("日期解析失败", e);
        }
    }

    public static Date parseDateByYYYY_MM_DDNoExp(String str) {
        if(StringUtils.isEmpty(str) || str.length() < 10){
            return null;
        }
        if(str.length() > 10){
            str = str.substring(0,10);
        }
        try {
            return DateUtils.parseDate(str, DATE_FORMAT_YYYY_MM_DD);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }


    /**
     * Obtains an instance of Date from an Instant object.
     */
    private static Date from(Instant instant) {
        return new Date(instant.toEpochMilli());
    }


    /**
     * Converts this timeMilli to an Instant.
     */
    private static Instant toInstant(Long timeMilli) {
        Date d = new Date(timeMilli);
        return d.toInstant();
    }


    /**
     * java.util.Date --> java.time.LocalDateTime
     */
    private static LocalDateTime udateToLocalDateTime(Date date) {
        Instant instant = date.toInstant();
        ZoneId zone = ZoneId.systemDefault();
        return LocalDateTime.ofInstant(instant, zone);
    }


    /**
     * java.util.Date --> java.time.LocalDate
     */
    private static LocalDate udateToLocalDate(Date date) {
        Instant instant = date.toInstant();
        ZoneId zone = ZoneId.systemDefault();
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, zone);
        return localDateTime.toLocalDate();
    }

    /**
     * java.util.Date --> java.time.LocalTime
     */
    private static LocalTime udateToLocalTime(Date date) {
        Instant instant = date.toInstant();
        ZoneId zone = ZoneId.systemDefault();
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, zone);
        return localDateTime.toLocalTime();
    }

    /**
     * java.time.LocalDateTime --> java.util.Date
     */
    private static Date localDateTimeToUdate(LocalDateTime localDateTime) {
        ZoneId zone = ZoneId.systemDefault();
        Instant instant = localDateTime.atZone(zone).toInstant();
        return Date.from(instant);
    }

    /**
     * java.time.LocalDate --> java.util.Date
     */
    public static Date localDateToUdate(LocalDate localDate) {
        ZoneId zone = ZoneId.systemDefault();
        Instant instant = localDate.atStartOfDay().atZone(zone).toInstant();
        return Date.from(instant);
    }

    /**
     * java.time.LocalDate + java.time.LocalTime --> java.util.Date
     */
    private static Date localTimeToUdate(LocalDate localDate, LocalTime localTime) {
        LocalDateTime localDateTime = LocalDateTime.of(localDate, localTime);
        return localDateTimeToUdate(localDateTime);
    }

    /***
     * 将时间戳字符串转换为特定格式的日期字符串
     * @param s
     * @param formatType
     * @return
     */
    public static String parseTimestampToDate(String s,String formatType){
        if(StringUtils.isEmpty(s)||StringUtils.isEmpty(formatType)){
          return null;
        }
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(formatType);
            Instant instant = toInstant(new Long(s));
            ZoneId zone = ZoneId.systemDefault();
            LocalDateTime dateTime = LocalDateTime.ofInstant(instant, zone);
            return formatter.format(dateTime);
        } catch (Exception e) {
            throw new BusinessSysException("日期解析失败", e);
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
            throw new BusinessSysException("日期解析失败", e);
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
            throw new BusinessSysException("日期解析失败", e);
        }
    }

    /**
     * 将yyyy-MM-dd HH:mm:ss的字符串转换成DatelocalDateTimeToUdate
     *
     * @param str 需要转换的字符串
     * @return 转换之后的时间
     */
    public static Date parseDateByYYYYMMDD_HHmmss(String str) {
        try {
            return DateUtils.parseDate(str, DATE_FORMAT_YYYYMMDD_HHMMSS);
        } catch (ParseException e) {
            throw new BusinessSysException("日期解析失败", e);
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

    public static String formatDateByYYYY_MM_DDNoExp(Date date) {
        if(date == null){
            return null;
        }
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
     * 将Date转换成yyyy-MM-dd HH:mm:ss的字符串
     *
     * @param date 需要转换的时间
     * @return 转换之后的时间字符串
     */
    public static String formatDateByYYYYMMdd_HHmmss(Date date) {
        return DateFormatUtils.format(date, DATE_FORMAT_YYYYMMDD_HHMMSS);
    }

    /**
     * 将Date转换成yyyy-MM-dd HH:mm:ss的字符串
     *
     * @param date 需要转换的时间
     * @return 转换之后的时间字符串
     */
    public static String formatDateByYYYYMMdd_HHmmssNoExp(Date date) {
        if(date == null){
            return null;
        }
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
     * @param date    需要转换的时间字符串
     * @param pattern 时间格式字符串
     * @return 转换后的时间
     */
    public static Date parseDateByPattern(String date, String pattern) {
        try {
            return DateUtils.parseDate(date, pattern);
        } catch (ParseException e) {
            throw new BusinessSysException("日期解析失败", e);
        }
    }

    /**
     * 时间转化
     *
     * @param date    需要转换的时间
     * @param pattern 时间格式字符串
     * @return 转换后的时间字符串
     */
    public static String formatDateByPattern(Date date, String pattern) {
        return DateFormatUtils.format(date, pattern);
    }


    /**
     * 时间转化
     *
     * @param date    需要转换的时间
     * @param pattern 时间格式字符串
     * @param locale 指定本地语种
     * @return 转换后的时间字符串
     */
    public static String formatDateByLocalePattern(final Date date, final String pattern, final Locale locale) {
        return DateFormatUtils.formatUTC(date, pattern, locale);
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
     * 计算两个日期相隔的天数（前者减后者）
     *
     * @param date1
     * @param date2
     * @return
     */
    public static int getDays(Date date1, Date date2) {
        LocalDate ldt1 = udateToLocalDate(date1);
        LocalDate ldt2 = udateToLocalDate(date2);
        return (int)(ldt1.toEpochDay() - ldt2.toEpochDay());
    }


    /**
     * 获得当前日期所在月份的第一天
     *
     * @return
     */
    public static Date getFirstDayOfCurrentMonth(Date dateParam) {
        LocalDate localDate = udateToLocalDate(dateParam);
        return localDateToUdate(localDate.withDayOfMonth(1));
    }

    public static String getFirstDay(Date date){
        LocalDate localDate = udateToLocalDate(date);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMAT_YYYYMMDD);
        return formatter.format(localDate.withDayOfMonth(1));
    }

    /**
     * 获得当前日期所在月份的最后一天
     *
     * @return
     */
    public static Date getEndDayOfCurrentMonth(Date dateParam) {
        LocalDate localDate = udateToLocalDate(dateParam);
        return localDateToUdate(localDate.with(TemporalAdjusters.lastDayOfMonth()));
    }

    public static String getEndDay(Date date){
        LocalDate localDate = udateToLocalDate(date);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMAT_YYYYMMDD);
        return formatter.format(localDate.with(TemporalAdjusters.lastDayOfMonth()));
    }

    /**
     * 获得当前日期所在上个月的第一天
     *
     * @return
     */
    public static Date getFirstDayOfLastMonth(Date dateParam) {
        Date endDayOfLastMonth = getEndDayOfLastMonth(dateParam);
        return getFirstDayOfCurrentMonth(endDayOfLastMonth);
    }


    /**
     * 获得当前日期所在上个月的最后一天
     *
     * @return
     */
    public static Date getEndDayOfLastMonth(Date dateParam) {
        Date firstDayOfThisMonth = getFirstDayOfCurrentMonth(dateParam);
        return addDate(firstDayOfThisMonth, -1);
    }


    /**
     * 获得本周的第一天
     *
     * @return
     */
    public static Date getFirstDayOfCurrentWeek(Date dateParam) {
        int i = daysInWeek(dateParam);
        return addDate(dateParam, 1 - i);
    }

    /**
     * 获得本周的最后一天
     *
     * @return
     */
    public static Date getEndDayOfCurrentWeek(Date dateParam) {
        int i = daysInWeek(dateParam);
        return addDate(dateParam, 7 - i);
    }

    /**
     * 获得上周的第一天
     *
     * @return
     */
    public static Date getFirstDayOfLastWeek(Date dateParam) {
        int i = daysInWeek(dateParam);
        return addDate(dateParam, 1 - i - 7);
    }

    /**
     * 获得上周的最后一天
     *
     * @return
     */
    public static Date getEndDayOfLastWeek(Date dateParam) {
        int i = daysInWeek(dateParam);
        return addDate(dateParam, 0 - i);
    }

    /**
     * 计算当前日期在一周的第几天, 周一返回1， 周日返回7
     *
     * @param date
     * @return
     */
    public static int daysInWeek(Date date) {
        LocalDate localDate = udateToLocalDate(date);
        return localDate.getDayOfWeek().getValue();
    }


    /**
     * 比较是否同天
     *
     * @param date1
     * @param date2
     * @return
     */
    public static boolean isSameDate(Date date1, Date date2) {
        LocalDate lDate1 = udateToLocalDate(date1);
        LocalDate lDate2 = udateToLocalDate(date2);
        return lDate1.toString().equals(lDate2.toString());
    }

    /**
     * @param millis
     * @return
     */
    public static int getHourByMillis(final Long millis) {
        return (int) ceil(millis.doubleValue() / 1000 / 60 / 60);
    }



    public static String getTodayFormat(String format) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        return formatter.format(LocalDateTime.now());
    }


    /**
     * 根据day日期进行加法计算
     *
     * @param date
     * @param day
     * @return
     * @returnType Date
     */
    public static Date addDate(Date date, int day) {
        LocalDateTime localDateTime = udateToLocalDateTime(date);
        return localDateTimeToUdate(localDateTime.plusDays(day));
    }

    /**
     * 根据day日期进行加法计算
     *
     * @param time
     * @param day
     * @return
     * @returnType Date
     */
    public static Date addDate(Long time, int day) {
        LocalDateTime localDateTime = udateToLocalDateTime(from(toInstant(time)));
        return localDateTimeToUdate(localDateTime.plusDays(day));
    }
    /**
     * 根据day日期进行加法计算
     *
     * @param date
     * @param minutes
     * @return
     * @returnType Date
     */
    public static Date addMinutes(Date date, int minutes) {
        LocalDateTime localDateTime = udateToLocalDateTime(date);
        return localDateTimeToUdate(localDateTime.plusMinutes(minutes));
    }

    /**
     * @param dateStr
     * @param pattern
     * @param day
     * @return
     * @returnType String
     */
    public static String addDate(String dateStr, String pattern, int day) {
        Date date = parseDateByPattern(dateStr,pattern);
        Date targetDate = addDate(date, day);
        return formatDateByPattern(targetDate, pattern);
    }

    /**
     * 返回前几天日期
     * @param count
     * @return
     */
    public static String getNWordDayBefor(int count, String formatType) {
        Date laterDate = localDateTimeToUdate(LocalDateTime.now().plusDays(count));
        return formatDateByPattern(laterDate, formatType);
    }


    public static String convertLongToDateString(String format, Long time) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
            Instant instant = toInstant(time);
            ZoneId zone = ZoneId.systemDefault();
            LocalDateTime dateTime = LocalDateTime.ofInstant(instant, zone);
            return formatter.format(dateTime);
        } catch (Exception e) {
            return "";
        }
    }

    /**
     * 获取对应日期是周几  -- 中文展现
     * @param date
     * @return
     */
    public static String getWeekOfDate(Date date) {
        //挪动到公用方法
        String []weekDays = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};
        LocalDate localDate = udateToLocalDate(date);
        int w = localDate.getDayOfWeek().getValue() % 7;
        return weekDays[w];
    }

    /**
     * 根据开始日期、结束日期返回区间日期
     * @param startDate
     * @param endDate
     * @param formatType
     * @return List(包含开始日期、包含结束日期)
     */
    public static List getRegionDayForDate(String startDate, String endDate, String formatType) {
        List dayList = new ArrayList();
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(formatType);
            LocalDate localDateStart = LocalDate.parse(startDate, formatter);
            LocalDate localDateEnd = LocalDate.parse(endDate, formatter);
            for (LocalDate d = localDateStart; !d.isAfter(localDateEnd); d = d.plusDays(1)) {
                dayList.add(d.format(formatter));
            }
        } catch (Exception e) {
            log.info("错误信息", e);
        }
        return dayList;
    }

    // 获取当天开始的时间戳
    public static long getStartTimeStamp() {
        LocalDateTime zeroTime = LocalDateTime.of(LocalDate.now(), LocalTime.MIN);
        return zeroTime.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
    }

    // 获取当天结束的时间戳
    public static long getEndTimeStamp() {
        LocalDateTime zeroTime = LocalDateTime.of(LocalDate.now(), LocalTime.MAX);
        return zeroTime.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
    }

    // 获取本周第一天开始的时间戳
    public static long getWeekStartStamp() {
        LocalDate today = LocalDate.now();
        return today.with(DayOfWeek.MONDAY).atStartOfDay().atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
    }

    // 获取本月第一天开始的时间戳
    public static long getMonthStartStamp() {
        LocalDate today = LocalDate.now();
        return today.with(TemporalAdjusters.firstDayOfMonth()).atStartOfDay().atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
    }


    public static long getDateStartStamp(long time) {
        LocalDateTime thisTime = LocalDateTime.ofInstant(new Date(time).toInstant(), ZoneId.systemDefault());
        LocalDateTime zeroTime = LocalDateTime.of(thisTime.toLocalDate(), LocalTime.MIN);
        return zeroTime.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
    }

    public static long getDateEndStamp(long time) {
        LocalDateTime thisTime = LocalDateTime.ofInstant(new Date(time).toInstant(), ZoneId.systemDefault());
        LocalDateTime zeroTime = LocalDateTime.of(thisTime.toLocalDate(), LocalTime.MAX);
        return zeroTime.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
    }

    public static int differentDays(Date date1,Date date2) {
        LocalDate localDate1 = udateToLocalDate(date1);
        LocalDate localDate2 = udateToLocalDate(date2);
        return (int)localDate1.until(localDate2, ChronoUnit.DAYS);
    }

    /**
     * 获取今天剩余时间
     * @return
     */
    public static Long getTodayTimeRemaining(){
        LocalTime midnight = LocalTime.MIDNIGHT;
        LocalDate today = LocalDate.now();
        LocalDateTime todayMidnight = LocalDateTime.of(today,midnight);
        LocalDateTime tomorrowMidnight = todayMidnight.plusDays(1);
        long seconds = TimeUnit.NANOSECONDS.toSeconds(Duration.between(LocalDateTime.now(), tomorrowMidnight).toNanos());
        return seconds;
    }


    public static Date getWorkDay (List<String> holidays, String today ,int days){
        Date date = parseDateByPattern(today,DATE_FORMAT_YYYYMMDD);
        Date tomorrow = null;
        int delay = 1;
        while (delay <= days){
            tomorrow = addDate(date,1);
            if (isHoliDay(formatDateByYYYYMMDD(tomorrow),holidays)){
                date = tomorrow;
            }else {
                delay ++;
                date = tomorrow;
            }
        }
        return date;
    }

    public static boolean isHoliDay(String date,List<String> holidays){
        if (!CollectionUtils.isEmpty(holidays)){
            return holidays.contains(date);
        }
        return false;
    }

    public static boolean isDateSunday(Date date) {
        LocalDate localDate = udateToLocalDate(date);
        return localDate.getDayOfWeek().getValue()==6||localDate.getDayOfWeek().getValue()==7;
    }
    /**
     * 获取指定日期范围内的所有指定星期 包含开始日期和结束日期
     * @param weeks 1,3,7表示周一，周三，周日
     * @return List<LocalDate>
     */
    public static List<LocalDate> getWeekLocalDateListByRange(LocalDate startDay, LocalDate endDay, List<String> weeks) {
        List<LocalDate> localDateList = new ArrayList<>();
        TemporalField fieldISO = WeekFields.of(DayOfWeek.of(1), 1).dayOfWeek();
        LocalDate tempDay;
        for (String week : weeks) {
            tempDay = startDay.with(fieldISO, Long.parseLong(week));
            if (tempDay.isBefore(startDay)) {
                tempDay = tempDay.plusWeeks(1);
            }
            while (tempDay.isBefore(endDay) || tempDay.isEqual(endDay)) {
                localDateList.add(tempDay);
                tempDay = tempDay.plusWeeks(1);
            }
        }
        return localDateList;
    }

    /**
     * 获取上一月的月份
     * @return
     */
    public static int getLastMonth(){
        LocalDate date = LocalDate.now();
        date = date.minusMonths(1);
        return date.getMonthValue();
    }

    /**
     * 获取上一季度
     * @return
     */
    public static int getLastQuarter(){
        int  n =  LocalDate.now().getMonthValue();
        return ((n-1)/3 + 3)%4 + 1;
    }

    /**
     * 获取上一半年（1：上半年，2：下半年）
     * @return
     */
    public static int getLastHalfYear(){
        int  n =  LocalDate.now().getMonthValue();
        if(n<=6){
            return 2;
        }else{
            return 1;
        }
    }

    /**
     * 获取上一年
     * @return
     */
    public static int getLastYear(){
        int  n =  LocalDate.now().getYear();
        return n-1;
    }

    /**
     * 获取上一月的月份对应的年
     * @return
     */
    public static int getLastMonthYear(){
        LocalDate date = LocalDate.now();
        date = date.minusMonths(1);
        return date.getYear();
    }

    /**
     * 获取上一季度对应的年
     * @return
     */
    public static int getLastQuarterYear(){
        LocalDate now =LocalDate.now();
        if(now.getMonthValue()>=1 && now.getMonthValue()<=3) {
            return now.getYear()-1;
        }
        return now.getYear();
    }

    /**
     * 获取上一半年（1：上半年，2：下半年）对应的年
     * @return
     */
    public static int getLastHalfYearYear(){
        LocalDate now =LocalDate.now();
        if(now.getMonthValue()<=6){
            return now.getYear()-1;
        }else{
            return now.getYear();
        }
    }

    /**
     * 目标日期偏移n个工作日
     * @param date
     * @param offset
     * @return
     */
    public static Date getOffsetDate(Date date,Integer offset){
        Integer offsetNum = 0;
        LocalDate now = null;
        if(date==null){
            now = LocalDate.now();
        }else{
            now=udateToLocalDate(date);
        }
        if(offset==null||offset.equals(offsetNum)){
            return localDateToUdate(now);
        }else if(offset>offsetNum){
            while(offset>offsetNum){
                now = now.plusDays(1);
                if(now.getDayOfWeek().getValue()!=6&&now.getDayOfWeek().getValue()!=7){
                    offsetNum++;
                }
            }
        }else{
            while(offset<offsetNum){
                now = now.plusDays(-1);
                if(now.getDayOfWeek().getValue()!=6&&now.getDayOfWeek().getValue()!=7){
                    offsetNum--;
                }
            }
        }
        return localDateToUdate(now);
    }

    /**
     * 获取指定日期设置指定时间
     * @param time
     * @param hours
     * @param minutes
     * @param second
     * @param nanoOfSecond
     * @return
     */
    public static Date getTargetDate(Long time,int hours,int minutes,int second,int nanoOfSecond){
        LocalDateTime localDateTime = LocalDateTime.of(udateToLocalDate(from(toInstant(time))),
                LocalTime.of(hours,minutes,second,nanoOfSecond));
        return localDateTimeToUdate(localDateTime);
    }

}
