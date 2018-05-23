package com.ajayhao.mslab.antxchecker.test.reflect;

import com.ajayhao.mslab.antxchecker.demos.PersonVO;
import com.ajayhao.mslab.antxchecker.demos.reflect.*;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.lang.reflect.InvocationTargetException;

/**
 * Created by haozhenjie on 2017/10/2.
 */
public class TestReflect {

    private JdkProxy jdkProxy;
    private CGLibProxy cgLibProxy;
    private ASMProxy asmProxy;
    private JavassistProxy javassistProxy;

    @BeforeTest
    public void setUp(){
        jdkProxy = new JdkProxy();
        cgLibProxy = new CGLibProxy();
        asmProxy = new ASMProxy();
        javassistProxy = new JavassistProxy();
    }

    @Test
    public void testJdkProxy(){
        //创建被代理的对象(接口类型)
        PersonService proxy = jdkProxy.getProxy(new PersonServiceImpl());
        PersonVO ret = proxy.buildVO(1, "冯宝宝");
        Assert.assertEquals( ret.getName(), "冯**");
    }


    @Test
    public void testCGLibProxy(){
        PersonService proxy = (PersonServiceImpl)cgLibProxy.getProxy(PersonServiceImpl.class);
        PersonVO ret = proxy.buildVO(1, "冯宝宝");
        Assert.assertEquals( ret.getName(), "冯##");
    }


    @Test
    public void testASMProxy(){
        String className = "PersonServiceASMProxy";
        Object obj = asmProxy.getProxy(className);
        try {
            obj.getClass().getDeclaredMethod("sayHello").invoke(obj);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        Assert.assertEquals(obj.getClass().getCanonicalName(),className);
    }

    @Test
    public void testJavassistProxy(){
        PersonService proxy = (PersonService)javassistProxy.getProxy();
        PersonVO ret = proxy.buildVO(1, "冯宝宝");
        Assert.assertEquals( ret.getName(), "冯宝宝哈哈哈");
    }
}
