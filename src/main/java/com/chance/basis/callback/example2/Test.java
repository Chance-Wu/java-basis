package com.chance.basis.callback.example2;

import com.chance.basis.callback.example1.Student;

/**
 * @Description: Test
 * @Author: chance
 * @Date: 2020-09-23 13:53
 * @Version 1.0
 */
public class Test {

    public static void main(String[] args) {
        int a = 168;
        int b = 291;
        Student student = new Student("小明");
        student.fillBlank(a, b);
    }
}
