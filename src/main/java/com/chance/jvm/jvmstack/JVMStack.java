package com.chance.jvm.jvmstack;

/**
 * @Description: JVMStack
 * @Author: chance
 * @Date: 2020-11-02 13:37
 * @Version 1.0
 */
public class JVMStack {

    public static void main(String[] args) {
        int result = add(5, 7);
        System.out.println("Result: " + result);
    }

    public static int add(int a, int b) {
        int sum = a + b;
        return sum;
    }
}
