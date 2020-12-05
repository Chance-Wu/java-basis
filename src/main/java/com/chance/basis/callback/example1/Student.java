package com.chance.basis.callback.example1;

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

    /**计算加法*/
    public int calcAdd(int a, int b) {
        return a + b;
    }

    /**填空*/
    public void fillBlank(int a, int b) {
        int result = calcAdd(a, b);
        System.out.println(name + "计算：" + a + " + " + b + " = " + result);
    }
}
