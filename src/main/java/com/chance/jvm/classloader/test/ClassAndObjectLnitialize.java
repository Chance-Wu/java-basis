package com.chance.jvm.classloader.test;

/**
 * @Description: ClassAndObjectLnitialize
 * @Author: chance
 * @Date: 12/31/20 3:30 PM
 * @Version 1.0
 */
public class ClassAndObjectLnitialize {

    public static void main(String[] args) {
//        new ClassAndObjectLnitialize();
        System.out.println("输出的打印语句");
    }

    public ClassAndObjectLnitialize() {

        System.out.println("构造方法");
        System.out.println("我是熊孩子我的智商=" + ZhiShang + ",情商=" + QingShang);
    }

    {
        System.out.println("普通代码块");
    }

    int ZhiShang = 250;
    static int QingShang = 666;

    static {
        System.out.println("静态代码块");
    }
}
