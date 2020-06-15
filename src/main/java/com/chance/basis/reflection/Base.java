package com.chance.basis.reflection;

/**
 * <p>
 * Class对象
 * <p>
 *
 * @author chance
 * @since 2020-02-19
 */
public class Base {
    static int num = 1;

    static {
        System.out.println("Base " + num);
    }
}

class Base2 {
    public static void main(String[] args) throws ClassNotFoundException {
        //不会初始化静态块
        Class clazz1 = Base.class;
        System.out.println("-----");
        //会初始化静态块
        Class clazz2 = Class.forName("com.chance.basis.reflection.Base");
    }
}
