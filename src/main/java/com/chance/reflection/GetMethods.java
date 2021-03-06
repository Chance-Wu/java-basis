package com.chance.reflection;

import java.lang.reflect.Method;

/**
 * @Description: GetMethods
 * @Author: chance
 * @Date: 2020-10-28 23:06
 * @Version 1.0
 */
public class GetMethods {

    public static void main(String[] args) {
        try {
            // 1.获取Class对象
            Class stuClass = Class.forName("com.chance.reflection.Student");
            // 2.获取所有公有方法
            System.out.println("***************获取所有的”公有“方法*******************");
            stuClass.getMethods();
            Method[] methodArray = stuClass.getMethods();
            for (Method m : methodArray) {
                System.out.println(m);
            }
            System.out.println("***************获取所有的方法，包括私有的*******************");
            methodArray = stuClass.getDeclaredMethods();
            for (Method m : methodArray) {
                System.out.println(m);
            }
            System.out.println("***************获取公有的show1()方法*******************");
            Method m = stuClass.getMethod("show1", String.class);
            System.out.println(m);
            // 实例化一个Student对象
            Object obj = stuClass.getConstructor().newInstance();
            m.invoke(obj, "刘德华");

            System.out.println("***************获取私有的show4()方法******************");
            m = stuClass.getDeclaredMethod("show4", int.class);
            System.out.println(m);
            // 暴力反射，解除私有限定
            m.setAccessible(true);
            // 需要两个参数，一个是要调用的对象（获取有反射），一个是实参
            Object result = m.invoke(obj, 20);
            System.out.println("返回值：" + result);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
