package com.chance.jvm.gc;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: GCTest
 * @Author: chance
 * @Date: 2020-11-04 09:57
 * @Version 1.0
 */
public class GCTest {

    public static void main(String[] args) {
        int i = 0;
        try {
            List<String> list = new ArrayList<>();
            String a = "Hello World!";
            while (true) {
                list.add(a);
                a = a + a;
                i++;
            }
        } catch (Exception e) {
            e.getStackTrace();
        }
    }
}
