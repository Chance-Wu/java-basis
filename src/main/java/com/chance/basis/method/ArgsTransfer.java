package com.chance.basis.method;

/**
 * @Description: 值传递机制（1.形参是基本数据类型；2.形参是引用数据类型）
 * @Author: chance
 * @Date: 2020-09-21 10:23
 * @Version 1.0
 */
public class ArgsTransfer {

    public static void main(String[] args) {
        int i = 10;
        int j = 5;

        ArgsTransfer testArgsTransfer = new ArgsTransfer();
        testArgsTransfer.swap(i, j);

        System.out.println("i:" + i + "\t" + "j:" + j);
    }

    /**
     * 定义一个方法，交换两个变量的值
     */
    public void swap(int i, int j) {
        int temp = i;
        i = j;
        j = temp;
        System.out.println("i:" + i + "\t" + "j:" + j);
    }

}
