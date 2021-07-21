package com.chance.basis.typeofdata;

/**
 * @Description: CharTest
 * @Author: chance
 * @Date: 6/23/21 1:46 PM
 * @Version 1.0
 */
public class CharTest {

    public static void main(String[] args) {
        char[] chs = Character.toChars(0x10437);
        System.out.printf("U+10437 高代理字符: %04x%n", (int) chs[0]);
        System.out.printf("U+10437 低代理字符: %04x%n", (int) chs[1]);
        String str = new String(chs);
        System.out.println(str);
        System.out.println("代码单元长度: " + str.length());
        System.out.println("代码点数量: " + str.codePointCount(0, str.length()));


    }
}
