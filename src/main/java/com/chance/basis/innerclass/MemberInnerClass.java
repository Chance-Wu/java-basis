package com.chance.basis.innerclass;

/**
 * @Description: MemberInnerClass
 * @Author: chance
 * @Date: 2020-10-31 13:59
 * @Version 1.0
 */
public class MemberInnerClass {

    private static int a;
    private int b;

    public class Inner {
        public void print() {
            System.out.println(a);
            System.out.println(b);
        }
    }
}
