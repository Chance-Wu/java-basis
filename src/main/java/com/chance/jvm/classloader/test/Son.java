package com.chance.jvm.classloader.test;

/**
 * @Description: Son
 * @Author: chance
 * @Date: 12/31/20 3:01 PM
 * @Version 1.0
 */
public class Son extends Father {

    public static String strSon = "HelloJVM_Son";

    static {
        System.out.println("Son静态代码块");
    }
}
