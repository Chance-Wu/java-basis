package com.chance.basis.innerclass;

/**
 * @Description: StaticInnerClass
 * @Author: chance
 * @Date: 2020-10-31 09:26
 * @Version 1.0
 */
public class StaticInnerClass {

    private static int a;
    private int b;

    public static class Inner {
        public void print() {
            System.out.println(a);
        }
    }
}
