package com.chance.jvm;

import com.chance.designpatterns.patterns.entity.User;

/**
 * @Description: Math
 * @Author: chance
 * @Date: 2020-11-02 10:41
 * @Version 1.0
 */
public class Math {

    private static final int initData = 666;
    private static User user = new User();
    private int initData1 = 666;

    /**
     * 一个方法对应一块栈帧内存区域
     */
    public int compute() {
        int a = 1;
        int b = 2;
        int c = (a + b) * 10;
        return c;
    }

    public static void main(String[] args) {
        Math math = new Math();
        math.compute();
    }
}
