package com.chance.basis.bitoperator;

import org.junit.Test;

/**
 * @Description: 位运算是直接对二进制进行运算
 * @Author: chance
 * @Date: 2020-09-19 15:14
 * @Version 1.0
 */
public class BitOperatorTest {

    /**
     * 左移：
     * 被移除的高位丢弃，
     * 空缺位补0。
     */
    @Test
    public void shiftLeft() {
        int a = 3 << 2;
        int b = 3 * 2 * 2;
        System.out.println(String.format("a=%d,b=%d", a, b));
    }

    /**
     * 右移：
     * 被移位的二进制最高位是0，右移后，空缺位补0，
     * 最高位是1，
     * 空缺位是1。
     */
    @Test
    public void shiftRight() {
        int a = 3 >> 1;
        int b = 3 / 2;
        System.out.println(String.format("a=%d,b=%d", a, b));
    }

    /**
     * 无符号右移：
     * 被移位二进制最高位无论是0或者是1，
     * 空缺位都用0补。
     */
    @Test
    public void unsignedRightShift() {
        int a = 3 >>> 1;
        System.out.println(String.format("a=%d", a));
    }

    /**
     * 与运算：
     * 只有1&1时结果是1，
     * 否则是0。
     */
    @Test
    public void andOperation() {
        int a = 6 & 3;
        System.out.println(String.format("a=%d", a));
    }

    /**
     * 或运算：
     * 只有0|0时结果是0，
     * 否则是1。
     */
    @Test
    public void orOperation() {
        int a = 6 | 3;
        System.out.println(String.format("a=%d", a));
    }

    /**
     * 异或运算：
     * 相同二进制位进行^运算，结果是0：1^1=0,0^0=0
     * 不相同二进制位^运算结果是1：1^0=1,0^1=1
     */
    @Test
    public void xOrOperation() {
        int a = 6 ^ 3;
        System.out.println(String.format("a=%d", a));
    }

    /**
     * 反码运算：
     * 整数取反，各二进制码按补码各位取反；
     * 负数取反，各二进制码按补码各位取反
     */
    @Test
    public void complementOperation() {
        int a = ~6;
        System.out.println(String.format("a=%d", a));
    }
}
