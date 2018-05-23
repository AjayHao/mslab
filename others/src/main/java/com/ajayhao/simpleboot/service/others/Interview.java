package com.ajayhao.simpleboot.service.others;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by AjayHao on 2017/7/6.
 *
 *  记录某些奇葩面试题
 */
public class Interview {

    /*从一个不可预知的对象数组中统计包含字符串值为A的个数，不考虑对象成员为A的情况*/
    public int getAfromArr(Object[] objArr){
        if(objArr == null) return 0;
        int i = 0;
        for(Object obj : objArr){
            if(obj instanceof String){
                if("A".equals(obj)){
                    i++;
                }
            }else if(obj instanceof Object[]){
                i = i + getAfromArr((Object[])obj);
            }
        }
        return i;
    }

    public static void main(String[] args){
        Interview i1 = new Interview();
        List<Object> list = new ArrayList();
        list.add("A");
        list.add(Integer.MAX_VALUE);
        Object[] obj = {"3", new BigDecimal("10"),Long.getLong("4"),"A"};
        list.add(obj);
        int ret = i1.getAfromArr(list.toArray());
        System.out.println("执行返回："+ret);
    }
}
