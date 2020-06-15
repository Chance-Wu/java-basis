package com.chance.basis.collection.list;

import java.util.ArrayList;

/**
 * <p>
 *
 * <p>
 *
 * @author chance
 * @since 2020-02-03
 */
public class TestArrayList {

    public static void main(String[] args) {
        ArrayList<Object> arrayList = new ArrayList<>();
        arrayList.add("01");
        arrayList.add("01");
        arrayList.add("02");
        System.out.println(arrayList);
        System.out.println(arrayList.get(0));
        System.out.println(arrayList.get(1));
        System.out.println(arrayList.get(2));
    }
}
