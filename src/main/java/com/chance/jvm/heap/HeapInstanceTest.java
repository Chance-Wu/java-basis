package com.chance.jvm.heap;

import java.util.ArrayList;
import java.util.Random;

/**
 * @Description: HeapInstanceTest
 * @Author: chance
 * @Date: 2020-11-03 16:30
 * @Version 1.0
 */
public class HeapInstanceTest {

    byte[] buffer = new byte[new Random().nextInt(1024 * 200)];

    public static void main(String[] args) throws InterruptedException {
        ArrayList<HeapInstanceTest> list = new ArrayList<>();
        while (true) {
            list.add(new HeapInstanceTest());
            Thread.sleep(10);
        }
    }
}
