package com.ajayhao.mslab.antxchecker.demos.annotation;

import static org.apache.commons.lang3.StringUtils.isNotBlank;

import java.lang.reflect.Field;

/**
 * Created by AjayHao on 2018/2/12.
 */
public class DBMappingTool<T> {

    public String query(T t){
        StringBuffer sb = new StringBuffer();
        Class c = t.getClass();
        if(!c.isAnnotationPresent(Table.class)){
            return null;
        }

        Table table = (Table)c.getAnnotation(Table.class);
        sb.append("select * from ").append(table.value()).append(" where 1=1");

        //字段的annotation
        for(Field f : c.getDeclaredFields()){
            //只处理不为null,且带Column注解的字段
            if(f.isAnnotationPresent(Column.class)){
                String columnName = f.getAnnotation(Column.class).value();
                //取值
                String fieldName = f.getName();
                String getter = "get" + fieldName.substring(0,1).toUpperCase() + fieldName.substring(1);
                try {
                    if(f.getType() == String.class || f.getType() == Character.TYPE){
                        String strVal = (String)c.getMethod(getter).invoke(t);
                        if(isNotBlank(strVal)){
                            sb.append(" and ").append(isNotBlank(columnName) ? columnName : fieldName)
                                    .append("='").append(strVal).append("'");
                        }
                    }else if(Number.class.isAssignableFrom(f.getType())){
                        Number numVal = (Number)c.getMethod(getter).invoke(t);
                        if(numVal != null){
                            sb.append(" and ").append(isNotBlank(columnName) ? columnName : fieldName)
                                    .append("=").append(numVal.toString());
                        }
                    }else if(Byte.TYPE == f.getType() || Short.TYPE == f.getType() || Integer.TYPE == f.getType() ||
                                Long.TYPE == f.getType() || Float.TYPE == f.getType() || Double.TYPE == f.getType()){
                        //基本类型
                        Number numVal = (Number)c.getMethod(getter).invoke(t);
                        if(numVal != null){
                            sb.append(" and ").append(isNotBlank(columnName) ? columnName : fieldName)
                                    .append("=").append(numVal.toString());
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        return sb.toString();
    }

}
