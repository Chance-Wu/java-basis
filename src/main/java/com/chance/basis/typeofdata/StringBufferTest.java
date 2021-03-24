package com.chance.basis.typeofdata;

/**
 * @Description: StringBufferTest
 * @Author: chance
 * @Date: 3/24/21 6:02 PM
 * @Version 1.0
 */
public class StringBufferTest {

    public static void main(String[] args) {
        StringBuffer stringBuffer = new StringBuffer();
        // 同步锁synchronized，线程安全
        stringBuffer.append("a");
        stringBuffer.append("b");
        System.out.println(stringBuffer.toString());
    }
}
