package com.chance.basis.typeofdata;

/**
 * @Description: StringBuilderTest
 * @Author: chance
 * @Date: 3/24/21 7:03 PM
 * @Version 1.0
 */
public class StringBuilderTest {

    public static void main(String[] args) {
//        StringBuilder stringBuilder = new StringBuilder();
//        stringBuilder.append("a");
//        stringBuilder.append("b");
//        System.out.println(stringBuilder);


        String s1 = "This is only a" + " simple" + " test";
        StringBuffer sb = new StringBuffer("This is only a").append(" simple").append(" test");
    }
}
