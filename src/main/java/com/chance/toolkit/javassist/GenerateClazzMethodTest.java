package com.chance.toolkit.javassist;

import com.sun.org.apache.xpath.internal.operations.String;
import javassist.*;
import org.junit.Test;

import java.lang.reflect.Method;

/**
 * <p>
 *
 * <p>
 *
 * @author chance
 * @since 2020-09-14
 */
public class GenerateClazzMethodTest {

    @Test
    public void generateClazzMethod() throws Exception {
        ClassPool pool = ClassPool.getDefault();

        // 1.创建类
        CtClass ctClass = pool.makeClass("target.classes.com.chance.toolkit.javassist.HelloWorld");

        // 2.添加方法
        CtMethod mainMethod = new CtMethod(CtClass.voidType, "main", new CtClass[]{pool.get(String[].class.getName())}, ctClass);
        mainMethod.setModifiers(Modifier.PUBLIC + Modifier.STATIC);
        mainMethod.setBody("{System.out.println(\"javassist hi helloworld by chance\");}");
        ctClass.addMethod(mainMethod);

        // 3.创建无参数构造方法
        CtConstructor ctConstructor = new CtConstructor(new CtClass[]{}, ctClass);
        ctConstructor.setBody("{}");
        ctClass.addConstructor(ctConstructor);

        // 4.输出此内容
        ctClass.writeFile();

        // 测试调用
        Class<?> clazz = ctClass.toClass();
        Object obj = clazz.newInstance();

        Method method = clazz.getDeclaredMethod("main", String[].class);
        method.invoke(obj, (Object) new String[1]);
    }

    @Test
    public void generateApi() throws Exception {
        ClassPool pool = ClassPool.getDefault();

        CtClass ctClass = pool.makeClass("target.classes.com.chance.toolkit.javassist.ApiTest");

        // 属性字段
        CtField ctField = new CtField(CtClass.doubleType, "π", ctClass);
        ctField.setModifiers(Modifier.PRIVATE + Modifier.STATIC + Modifier.FINAL);
        ctClass.addField(ctField, "3.14");

        // 方法：求圆的面积
        CtMethod calculateCircularArea = new CtMethod(CtClass.doubleType, "calculateCircularArea", new CtClass[]{CtClass.doubleType}, ctClass);
        calculateCircularArea.setModifiers(Modifier.PUBLIC);
        calculateCircularArea.setBody("{return π * $1 * $1;}");
        ctClass.addMethod(calculateCircularArea);

        // 方法：两数之和
        CtMethod sumOfTwoNumbers = new CtMethod(CtClass.doubleType, "sumOfTwoNumbers", new CtClass[]{CtClass.doubleType, CtClass.doubleType}, ctClass);
        sumOfTwoNumbers.setModifiers(Modifier.PUBLIC);
        sumOfTwoNumbers.setBody("return $1 + $2;");
        ctClass.addMethod(sumOfTwoNumbers);

        //输出类的内容
        ctClass.writeFile();
    }
}
