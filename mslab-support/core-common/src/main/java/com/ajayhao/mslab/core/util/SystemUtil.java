package com.ajayhao.mslab.core.util;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.UUID;

/**
 * 类DateUtils.java的实现描述：<br/>
 * 系统工具类
 * 
 * @author haozhenjie 2018年5月8日 下午10:58:06
 */

public class SystemUtil {

    /**
     * -
     */
    public final static String HYPHEN          = "-";

    public static String newUUID(){
        return UUID.randomUUID().toString().replaceAll(HYPHEN, "");
    }

    public static String newUUID36(){
        return UUID.randomUUID().toString();
    }


    public static void main(String[] args){
        int n = 10;
        for(int i = 0 ; i < n; i++){
            System.out.println(newUUID36());
        }
        System.out.println(StringUtils.join(new ArrayList<String>(), ","));
    }
}
