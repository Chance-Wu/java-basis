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

    public static void main(String[] args) {
        Integer a = 1;
        Integer b = 2;
        System.out.printf("a = %s, b = %s\n", a, b);
//        swap(a, b);
//        swap1(a, b);
        swap2(a, b);
        System.out.printf("a = %s, b = %s\n", a, b);
    }

    public static void swap2(Integer a, Integer b) {
        int temp = a.intValue();
        try {
            Field value = Integer.class.getDeclaredField("value");
            value.setAccessible(true);
            value.set(a, b);
            value.set(b, new Integer(temp));
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public static void swap1(Integer a, Integer b) {
        int temp = a.intValue();
        try {
            Field value = Integer.class.getDeclaredField("value");
            value.setAccessible(true);
            value.set(a, b);
            value.set(b, temp);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    /**
     * 错误的方式
     */
    public static void swap(Integer a, Integer b) {
        int temp = a;
        a = b;
        b = temp;
    }

}
