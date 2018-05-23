package com.ajayhao.simpleboot.demos.reflect;

import com.ajayhao.simpleboot.demos.PersonVO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created by haozhenjie on 2017/10/3.
 */
public class CGLibProxy implements MethodInterceptor{
    private Enhancer enhancer = new Enhancer();

    @Override
    public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        Object result = methodProxy.invokeSuper(o , args);
        if("buildVO".equals(method.getName())){
            if (args.length != 2) {
                throw new IllegalArgumentException("参数个数不正确");
            }

            if (result instanceof PersonVO) {
                String raw = ((PersonVO) result).getName();
                if (StringUtils.isNotEmpty(raw)) {
                    StringBuffer sensitiveName = new StringBuffer(raw.substring(0,1));
                    for (int i = 0; i < raw.length() - 1; i++) {
                        sensitiveName = sensitiveName.append("#");
                    }
                    ((PersonVO) result).setName(sensitiveName.toString());
                }
            }
        }
        return result;
    }

    public Object getProxy(Class clazz){
        //设置需要创建子类的类
        enhancer.setSuperclass(clazz);
        enhancer.setCallback(this);
        //通过字节码技术动态创建子类实例
        return enhancer.create();
    }
}
