package com.chance.basis.array;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p>
 *
 * <p>
 *
 * @author chance
 * @since 2019-11-03
 */
public class ArrayTest {

    /**
     * Arrays工具类
     */
    @Test
    public void testArrays() {
        String[] arr = {"2", "1", "4", "3", "6", "5"};
        String[] arr4 = {"1", "2", "4", "3", "6", "5"};
        int[] arr1 = {2, 1, 4, 3, 6, 5};
        int[] arr2 = {2, 1, 4, 3, 6, 5};
        // 1.数组转集合（返回一个受指定数组支持的固定大小的列表。）
        List<String> list = Arrays.asList(arr);
        for (String s : list) {
            System.out.println(s);
        }

        // 2.使用二分搜索法来搜索指定的 int 型数组，以获得指定的值的位置
        int i = Arrays.binarySearch(arr1, 0);
        System.out.println(i);

        // 3.将指定数组的指定范围复制到一个新数组
        String[] arr3 = Arrays.copyOfRange(arr, 2, 4);

        // 4.如果两个指定的int型狐族彼此相等，则返回true
        boolean b = Arrays.equals(arr, arr4);
        System.out.println(b);

        // 5.将指定的int值分配给指定int型数组的每个元素
        Arrays.fill(arr1, 2);
        for (int j : arr1) {
            System.out.println(j);
        }

        // 6.对指定的int型数组按数组升序进行排序
        Arrays.sort(arr2);

        // 7.返回指定数组内容的字符串表示形式
        System.out.println(Arrays.toString(arr2));
    }

    /**
     * 增加数组长度
     */
    @Test
    public void increaseArrayLength() {
        int[] original = {2, 1, 4, 3, 6, 5};
        int[] result = Arrays.copyOf(original, 10);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }

    /**
     * 初始化
     */
    @Test
    public void testDefineArray() {
        // 数组的声明、初始化
        int[] a1 = {1, 2, 3, 4, 5};
        int[] a2;
        a2 = a1;

        // 数组初始化形式1
        Integer[] a = {
                Integer.valueOf(1),
                Integer.valueOf(2),
                Integer.valueOf(3),
        };
        // 数组初始化形式2
        Integer[] b = new Integer[]{
                Integer.valueOf(1),
                Integer.valueOf(2),
                Integer.valueOf(3),
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
