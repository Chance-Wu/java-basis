package com.chance.basis.callback.example4;

/**
 * @Description: SuperCalculator
 * @Author: chance
 * @Date: 2020-09-23 14:13
 * @Version 1.0
 */
public class SuperCalculator {

    public void add(int a, int b, DoJob doJob) {
        int result = a + b;
        doJob.fillBlank(a,b,result);
    }
}
