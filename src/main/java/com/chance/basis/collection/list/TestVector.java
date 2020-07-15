package com.chance.basis.collection.list;

import java.util.Vector;

/**
 * <p>
 * Vector线程安全的，它的方法之间是线程同步的
 *
 * 如果只有一个线程会访问到集合，使用ArrayList；
 * 如果多个线程会访问到集合，那最好是使用Vector
 *
 * 扩容：Vector增长原来的一倍，ArrayList增加原来的0.5倍
 * <p>
 *
 * @author chance
 * @since 2020-06-20
 */
public class TestVector {

    public static void main(String[] args) {

        /**
         *
         */
        Vector<Object> vector = new Vector<>();
        vector.add("1");
        vector.add("1");
        vector.add("2");

        System.out.println(vector);
    }
}
