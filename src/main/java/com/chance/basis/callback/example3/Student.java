package com.chance.basis.callback.example3;

/**
 * @Description: Student
 * @Author: chance
 * @Date: 2020-09-23 13:46
 * @Version 1.0
 */
public class Student {

    private String name;

    public Student(String name) {
        this.name = name;
    }

    public void callHelp(int a, int b) {
        new SuperCalculator().add(a, b, this);
    }

    public void fillBlank(int a, int b, int result) {
        System.out.println(name + "求助小红计算：" + a + " + " + b + " = " + result);
    }
}
