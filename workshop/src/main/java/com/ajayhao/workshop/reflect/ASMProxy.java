package com.ajayhao.workshop.reflect;

import com.ajayhao.workshop.classloader.MyClassLoader;
import org.springframework.asm.ClassWriter;
import org.springframework.asm.MethodVisitor;
import org.springframework.asm.Opcodes;

/**
 * Created by haozhenjie on 2017/10/9.
 */
public class ASMProxy {
    /**
     * 使用ASM框架提供了ClassWriter 接口，通过访问者模式进行动态创建class字节码
     */
    public Object getProxy(String className){
        ClassWriter classWriter = new ClassWriter(0);
        // 通过visit方法确定类的头部信息
        classWriter.visit(Opcodes.V1_8, //java 版本
                Opcodes.ACC_PUBLIC, // 类修饰符
                className, //类全名
                null,
                "java/lang/Object",
                null);

        //创建构造函数
        MethodVisitor constructorVisitor = classWriter.visitMethod(Opcodes.ACC_PUBLIC, "<init>", "()V", null, null);
        constructorVisitor.visitCode();;
        constructorVisitor.visitVarInsn(Opcodes.ALOAD, 0);
        constructorVisitor.visitMethodInsn(Opcodes.INVOKESPECIAL, "java/lang/Object", "<init>", "()V");
        constructorVisitor.visitInsn(Opcodes.RETURN);
        constructorVisitor.visitMaxs(1,1);
        constructorVisitor.visitEnd();

        // 定义code方法
        MethodVisitor methodVisitor = classWriter.visitMethod(Opcodes.ACC_PUBLIC, "sayHello", "()V",
                null, null);
        methodVisitor.visitCode();
        methodVisitor.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out",
                "Ljava/io/PrintStream;");
        methodVisitor.visitLdcInsn("Hello world~");
        methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println",
                "(Ljava/lang/String;)V");
        methodVisitor.visitInsn(Opcodes.RETURN);
        methodVisitor.visitMaxs(2, 2);
        methodVisitor.visitEnd();
        classWriter.visitEnd();
        // 使classWriter类已经完成
        // 将classWriter转换成字节数组
        byte[] data = classWriter.toByteArray();
        MyClassLoader classLoader = new MyClassLoader();
        Class clazz = null;
        Object ret = null;
        try {
            clazz = classLoader.defineMyClass(className, data, 0, data.length);
            ret = clazz.newInstance();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        return ret;
    }

}

