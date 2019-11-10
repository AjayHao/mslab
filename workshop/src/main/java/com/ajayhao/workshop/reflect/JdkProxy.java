package com.ajayhao.workshop.reflect;

import com.ajayhao.workshop.PersonVO;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by AjayHao on 2017/7/13.
 *
 * Java反射Demo
 */
public class JdkProxy {

    /**
    * 反射机制的动态代理
    */
    public PersonService getProxy(final PersonService target){
        PersonService proxy = (PersonService) Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        Object result = method.invoke(target, args);
                        if("buildVO".equals(method.getName())){
                            if (args.length != 2) {
                                throw new IllegalArgumentException("参数个数不正确");
                            }

                            if (result instanceof PersonVO) {
                                String raw = ((PersonVO) result).getName();
                                if (StringUtils.isNotEmpty(raw)) {
                                    StringBuffer sensitiveName = new StringBuffer(raw.substring(0,1));
                                    for (int i = 0; i < raw.length() - 1; i++) {
                                        sensitiveName = sensitiveName.append("*");
                                    }
                                    ((PersonVO) result).setName(sensitiveName.toString());
                                }
                            }
                        }
                        return result;
                    }
                }
        );
        return proxy;
    }





}
