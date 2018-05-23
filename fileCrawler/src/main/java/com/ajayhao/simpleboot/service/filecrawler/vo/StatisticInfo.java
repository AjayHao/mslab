package com.ajayhao.simpleboot.service.filecrawler.vo;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by AjayHao on 2017/7/4.
 *
 * 文件基本信息
 */
public class StatisticInfo{

    private String ext;

    private AtomicLong totalSpace;

    private AtomicInteger totalCount;


    public StatisticInfo(){
        totalSpace = new AtomicLong(0L);
        totalCount = new AtomicInteger(0);
    }

    public StatisticInfo(String ext){
        this();
        this.ext = ext;
    }

    public StatisticInfo(String ext, long fileSize){
        this();
        this.ext = ext;
        atomicAddTotalSpace(fileSize);
        countIncrement();
    }

    public void atomicAddTotalSpace(long size) {
        totalSpace.addAndGet(size);
    }

    public void countIncrement(){
        totalCount.incrementAndGet();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StatisticInfo that = (StatisticInfo) o;

        return ext != null ? ext.equals(that.ext) : that.ext == null;

    }

    @Override
    public int hashCode() {
        return ext != null ? ext.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "StatisticInfo{" +
                "ext='" + ext + '\'' +
                ", totalSpace=" + new BigDecimal(totalSpace.longValue()/1024) + "K" +
                '}';
    }

    public Map getInfo(){
        Map m = new HashMap<String,String>();
        m.put("ext", ext);
        BigDecimal decimal;
        if(totalSpace!=null){
            decimal = new BigDecimal(totalSpace.doubleValue() / 1024);
            decimal = decimal.setScale(0, RoundingMode.UP);
        }else{
            decimal = BigDecimal.ZERO;
        }
        m.put("size", decimal.doubleValue());
        m.put("count", totalCount.intValue());
        return m;
    }
}
