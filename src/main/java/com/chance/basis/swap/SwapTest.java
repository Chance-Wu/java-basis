package com.chance.basis.swap;

import java.lang.reflect.Field;

/**
 * <p>
 *
 * <p>
 *
 * @author chance
 * @since 2020-07-15
 */
public class SwapTest {

    public static void main(String[] args) throws Exception {
        Integer a = 1;
        Integer b = 2;
        System.out.printf("a = %s, b = %s\n", a, b);
//        swap(a, b);
        swap1(a, b);
        System.out.printf("a = %s, b = %s\n", a, b);
    }

    public static void swap1(Integer a, Integer b) throws Exception {
        int temp = a.intValue();
        Field value = Integer.class.getDeclaredField("value");
        value.setAccessible(true);
        value.set(a, b);
        value.set(b, temp);
    }

    /**
     * 错误的方式，方法里面并没有改变原来的引用关系，a，b还是指向原来的Object对象
     */
    public static void swap(Integer a, Integer b) {
        int temp = a;
        a = b;
        b = temp;
    }

}
