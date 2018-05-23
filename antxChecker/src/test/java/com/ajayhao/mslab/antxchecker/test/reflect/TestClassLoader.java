package com.ajayhao.mslab.antxchecker.test.reflect;

import com.ajayhao.mslab.antxchecker.demos.classloader.MyClassLoader;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

/**
 * Created by haozhenjie on 2017/10/9.
 */
public class TestClassLoader {

    @Test
    public void testLoadClass() throws IOException{
        MyClassLoader classLoader = new MyClassLoader();
        Class clazz = classLoader.load(new File(".").getCanonicalPath() + "/target/classes/com/ajayhao/simpleboot/demos/PersonVO.class");
        Assert.assertEquals(clazz.getCanonicalName(), "PersonVO");
    }
}
