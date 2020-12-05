package com.chance.basis.callback.example1;

/**
 * @Description: Test
 * @Author: chance
 * @Date: 2020-09-23 13:53
 * @Version 1.0
 */
public class Test {

    public static void main(String[] args) {
        int a = 1;
        int b = 1;
        Student student = new Student("小明");
        student.fillBlank(a, b);
    }
}
