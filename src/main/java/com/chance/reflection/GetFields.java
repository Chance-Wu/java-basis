package com.chance.reflection;

import java.lang.reflect.Field;

/**
 * @Description: 获取成员对象
 * @Author: chance
 * @Date: 2020-10-28 22:20
 * @Version 1.0
 */
public class GetFields {

    public static void main(String[] args) {
        try {
            //1.获取Class对象
            Class stuClass = Class.forName("com.chance.reflection.Student");
            //2.获取字段
            System.out.println("************获取所有公有的字段********************");
            Field[] fieldArray = stuClass.getFields();
            for (Field f : fieldArray) {
                System.out.println(f);
            }
            System.out.println("************获取所有的字段(包括私有、受保护、默认的)********************");
            fieldArray = stuClass.getDeclaredFields();
            for (Field f : fieldArray) {
                System.out.println(f);
            }
            System.out.println("*************获取公有字段**并调用***********************************");
            Field f = stuClass.getField("name");
            System.out.println(f);
            //获取一个对象，产生Student对象--》Student stu = new Student();
            Object obj = stuClass.getConstructor().newInstance();
            //为字段设置值，为Student对象中的name属性赋值--》stu.name = "刘德华"
            f.set(obj, "chance");
            //验证
            Student stu = (Student) obj;
            System.out.println("验证姓名：" + stu.name);

            System.out.println("**************获取私有字段****并调用********************************");
            f = stuClass.getDeclaredField("phoneNum");
            System.out.println(f);
            //暴力反射，解除私有限定
            f.setAccessible(true);
            f.set(obj, "18888889999");
            System.out.println("验证电话：" + stu);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
