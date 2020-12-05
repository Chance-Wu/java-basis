package com.chance.basis.callback.example4;

/**
 * @Description: Test
 * @Author: chance
 * @Date: 2020-09-23 13:53
 * @Version 1.0
 */
public class Test {

    public static void main(String[] args) {
        int a = 56;
        int b = 31;
        int c = 26549;
        int d = 16487;
        Student student = new Student("小明");
        Seller seller = new Seller("老婆婆");
        student.callHelp(a,b);
        seller.callHelp(c,d);
    }
}
