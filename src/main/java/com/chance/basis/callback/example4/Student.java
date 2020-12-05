package com.chance.basis.callback.example4;

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

    class DoHomeWork implements DoJob {

        @Override
        public void fillBlank(int a, int b, int result) {
            System.out.println(name + "求助小红计算:" + a + " + " + b + " = " + result);
        }
    }

    public void callHelp (int a, int b) {
        new SuperCalculator().add(a, b, new DoHomeWork());
    }
}
