package com.chance.thread.cas;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Description: CASDemo
 * @Author: chance
 * @Date: 1/13/21 7:24 PM
 * @Version 1.0
 */
public class CASDemo {

    public static void main(String[] args) {
        //初始值
        AtomicInteger integer = new AtomicInteger(5);
        //比较并替换
        boolean flag = integer.compareAndSet(5, 10);
        boolean flag2 = integer.compareAndSet(5, 15);

        System.out.println("是否自选并替换 \t" + flag + "\t更改之后的值为：" + integer.get());
        System.out.println("是否自选并替换 \t" + flag2 + "\t更改之后的值为：" + integer.get());

        /**
         * 第一次修改，期望值为5，主内存也为5，修改成功，为10。
         *
         * 第二次修改，期望值为5，主内存为10，修改失败。
         */
    }
}
