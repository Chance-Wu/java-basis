package com.chance.jvm.classloader.test;

/**
 * @Description: Father
 * @Author: chance
 * @Date: 12/31/20 3:00 PM
 * @Version 1.0
 */
public class Father extends YeYe {

    public static String strFather = "HelloJVM_Father";

    static {
        System.out.println("Father静态代码块");
    }
}
