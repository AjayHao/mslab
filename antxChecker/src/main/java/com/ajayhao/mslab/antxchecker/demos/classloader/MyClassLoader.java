package com.ajayhao.mslab.antxchecker.demos.classloader;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by haozhenjie on 2017/10/9.
 */
public class MyClassLoader extends ClassLoader{

    public Class<?> defineMyClass(String name, byte[] b, int off, int len){
        return super.defineClass(name,b, off, len);
    }

    public Class<?> load(String classPath) throws IOException{
        //读取本地的class文件内的字节码，转换成字节码数组
        InputStream input = new FileInputStream(classPath);
        byte[] result = new byte[input.available()];

        int count = input.read(result);
        // 使用自定义的类加载器将 byte字节码数组转换为对应的class对象
        return defineMyClass(null, result, 0, count);
    }
}
