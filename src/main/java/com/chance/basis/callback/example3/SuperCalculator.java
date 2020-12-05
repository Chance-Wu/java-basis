package com.chance.basis.callback.example3;

/**
 * @Description: SuperCalculator
 * @Author: chance
 * @Date: 2020-09-23 14:13
 * @Version 1.0
 */
public class SuperCalculator {

    public void add(int a, int b, Student xiaoming) {
        int result = a + b;
        xiaoming.fillBlank(a,b,result);
    }
}
