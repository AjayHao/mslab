
package com.ajayhao.workshop.reflect;

import com.ajayhao.workshop.PersonVO;
import javassist.*;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by haozhenjie on 2017/10/9.
 */
public class JavassistProxy {

    public Object getProxy(){
        ClassPool pool = ClassPool.getDefault();
        CtClass ctClass = pool.makeClass("com.ajayhao.workshop.reflect.PersonServiceJavaassistProxy");

        Object proxy = null;

        try {
            //设置接口
            CtClass personServiceInterface = pool.get("com.ajayhao.workshop.reflect.PersonService");
            ctClass.setInterfaces(new CtClass[]{personServiceInterface});

            //设置Field
            CtField idField = CtField.make("private int id;", ctClass);
            ctClass.addField(idField);
            //设置field, 另一种方法
            CtField nameField = new CtField(pool.get("java.lang.String"), "name", ctClass);
            ctClass.addField(nameField);

            //构造器  1：参数类型   2：所属类CtClass
            CtClass personVOClass = pool.get("com.ajayhao.workshop.PersonVO");
            CtClass[] arrays = new CtClass[]{personVOClass};
            CtConstructor ctConstructor = new CtConstructor(arrays, ctClass);
            //设置构造函数内部逻辑
            StringBuffer body=new StringBuffer();
            body.append("{\n").append("$0.id=$1.getId();\n").append("$0.name=$1.getName();\n").append("}");
            ctConstructor.setBody(body.toString());
            ctClass.addConstructor(ctConstructor);

            //创建方法 buildVO  1：返回类型  2：方法名称  3：传入参数类型  4：所属类CtClass
            CtClass[] methodParamTypes = new CtClass[]{CtClass.intType, pool.get("java.lang.String")};
            CtMethod method = new CtMethod(personVOClass, "buildVO", methodParamTypes, ctClass);
            method.setModifiers(Modifier.PUBLIC);
            body = new StringBuffer();
            body.append("{\n ")
                        .append("$0.id = $1; \n")
                        .append("$0.name = $2 + \"哈哈哈\"; \n")
                        .append("return new com.ajayhao.workshop.PersonVO($0.id, $0.name);").append("\n}");
            method.setBody(body.toString());
            ctClass.addMethod(method);

            //获取动态生成的class
            Class c = ctClass.toClass();
            //获取构造器
            Constructor constructor= c.getConstructor(PersonVO.class);
            //通过构造器实例化
            proxy = constructor.newInstance(new PersonVO(1, "fakeName"));

        } catch (NotFoundException e) {
            e.printStackTrace();
        } catch (CannotCompileException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return proxy;
    }
}
