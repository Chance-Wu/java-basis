package com.chance.reflection;

/**
 * @Description: 获取Class对象的三种方式
 * @Author: chance
 * @Date: 2020-10-28 15:46
 * @Version 1.0
 */
public class GetClassObj {

    public static void main(String[] args) {
        // 方式一：
        // 产生一个Student对象，一个Class对象
        Student stu1 = new Student();
        // 获取Class对象
        Class stuClass = stu1.getClass();
        System.out.println(stuClass.getName());

        // 方式二：
        Class stuClass2 = Student.class;
        System.out.println(stuClass == stuClass2);

        // 方式三：
        try {
            // 此字符串必须是真实路径，包名.类名
            Class stuClass3 = Class.forName("com.chance.reflection.Student");
            System.out.println(stuClass3 == stuClass2);
            System.out.println(stuClass3.getDeclaredFields());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
