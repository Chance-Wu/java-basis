package com.chance.basis.callback.example2;

/**
 * @Description: Student
 * @Author: chance
 * @Date: 2020-09-23 13:46
 * @Version 1.0
 */
public class Student {

    private String name;

    public void setName(String name) {
        this.name = name;
    }

    /**
     * 填空
     */
    public void fillBlank(int a, int b) {
        int result = useAddCalculator(a, b);
        System.out.println(name + "计算：" + a + " + " + b + " = " + result);
    }

    /**
     * 使用加法计算器
     */
    public int useAddCalculator(int a, int b) {
        return new AddCalculator().add(a, b);
    }
}
