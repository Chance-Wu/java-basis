package com.chance.basis.array;

import org.junit.Test;

import java.util.ArrayList;

/**
 * <p>
 *
 * <p>
 *
 * @author chance
 * @since 2019-11-03
 */
public class ArrayTest {

    @Test
    public void testDefineArray() {
        // 数组的声明、初始化
        int[] a1 = {1, 2, 3, 4, 5};
        int[] a2;
        a2 = a1;

        // 数组初始化形式1
        Integer[] a = {
                new Integer(1),
                new Integer(2),
                new Integer(3),
        };
        // 数组初始化形式2
        Integer[] b = new Integer[]{
                new Integer(1),
                new Integer(2),
                new Integer(3),
        };
        // 静态初始化（初始化数组与给数组元素赋值同时进行）
        // 动态初始化（初始化数组与给数组元素赋值分开进行）

        // 遍历方式1
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
        // 遍历方式2
        for (Integer i : a) {
            System.out.println(i);
        }
    }

}
