package com.chance.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @Description: 通过反射获取构造方法并使用
 * @Author: chance
 * @Date: 2020-10-28 16:16
 * @Version 1.0
 */
public class GetConstructors {
    public static void main(String[] args) {
        try {
            Class clazz = Class.forName("com.chance.reflection.Student");

            //2.获取所有公有构造方法
            System.out.println("**********************所有公有构造方法*********************************");
            Constructor[] conArray = clazz.getConstructors();
            for (Constructor c : conArray) {
                System.out.println(c);
            }


            System.out.println("************所有的构造方法(包括：私有、受保护、默认、公有)***************");
            conArray = clazz.getDeclaredConstructors();
            for (Constructor c : conArray) {
                System.out.println(c);
            }

            System.out.println("*****************获取公有、无参的构造方法*******************************");
            Constructor con = clazz.getConstructor(null);
            // 1>、因为是无参的构造方法所以类型是一个null,不写也可以：这里需要的是一个参数的类型，切记是类型
            // 2>、返回的是描述这个无参构造函数的类对象。

            System.out.println("con = " + con);
            // 调用构造方法
            Object obj = con.newInstance();

            System.out.println("******************获取私有构造方法，并调用*******************************");
            con = clazz.getDeclaredConstructor(int.class);
            System.out.println(con);
            //调用构造方法
            //暴力访问(忽略掉访问修饰符)
            con.setAccessible(true);
            obj = con.newInstance(18);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
