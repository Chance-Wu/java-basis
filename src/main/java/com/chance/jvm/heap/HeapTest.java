package com.chance.jvm.heap;

import java.util.ArrayList;

/**
 * @Description: HeapTest
 * @Author: chance
 * @Date: 2020-11-06 10:23
 * @Version 1.0
 */
public class HeapTest {
    /**
     * 100KB
     */
    byte[] a = new byte[1024 * 100];

    public static void main(String[] args) throws InterruptedException {
        ArrayList<HeapTest> heapTests = new ArrayList<>();
        while (true) {
            heapTests.add(new HeapTest());
            Thread.sleep(10);
        }
    }
}
