package com.chance.basis.collection.list;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * <p>
 *
 * <p>
 *
 * @author chance
 * @since 2020-06-20
 */
public class TestArrayLsitAndLinkedList {

    public static void main(String[] args) {

        /**
         * ArrayList基于动态数组
         *
         * 线程不安全
         *
         * 优势：随机访问get、set
         */
        ArrayList<Object> arrayList = new ArrayList<>();
        arrayList.add("1");
        arrayList.add("1");
        arrayList.add("2");

        System.out.println(arrayList.get(2));
        System.out.println(arrayList.set(2,"1"));
        System.out.println(arrayList);

        /**
         * LinkedList基于链表
         *
         * 优势：新增和删除操作add和remove
         */
        LinkedList<Object> linkedList = new LinkedList<>();
        linkedList.add("1");
        linkedList.add("1");
        linkedList.add("2");

        linkedList.add("3");
        linkedList.remove("3");
        System.out.println(linkedList);
    }
}
