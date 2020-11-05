package com.chance.basis.generic;

/**
 * @Description: Test
 * @Author: chance
 * @Date: 2020-10-31 15:57
 * @Version 1.0
 */
public class GenericMethod {

    /**
     * 泛型方法
     * @param inputArray
     * @param <E>
     */
    public static <E> void printArray(E[] inputArray) {
        for (E element : inputArray) {
            System.out.printf("%s", element);
        }
    }
}
