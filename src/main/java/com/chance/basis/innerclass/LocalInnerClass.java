package com.chance.basis.innerclass;

/**
 * @Description: LocalInnerClass
 * @Author: chance
 * @Date: 2020-10-31 14:17
 * @Version 1.0
 */
public class LocalInnerClass {

    private static int a;
    private int b;

    public void test(final int c) {
        final int d = 1;
        class Inner {
            public void print() {
                System.out.println(c);
            }
        }
    }
}
