package com.chance.toolkit.utils;

/**
 * @Description: NumberUtils
 * @Author: chance
 * @Date: 4/5/21 10:21 AM
 * @Version 1.0
 */
public class NumberUtils {

    /**
     * 不够位数的在前面补0，保留num的长度位数字
     * @param number
     * @param length
     * @return
     */
    public static String autoGenericCode(int number, int length) {
        return String.format("%0" + length + "d", number);
    }

    public static void main(String[] args) {
        System.out.println(autoGenericCode(1, 3));
    }
}
