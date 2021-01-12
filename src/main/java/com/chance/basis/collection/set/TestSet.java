package com.chance.basis.collection.set;

import java.util.Set;
import java.util.TreeSet;

/**
 * @Description: TestSet
 * @Author: chance
 * @Date: 1/8/21 10:52 AM
 * @Version 1.0
 */
public class TestSet {

    public static void main(String[] args) {
        Set<String> set = new TreeSet<>();
        set.add("4");
        set.add("2");
        set.add("6");
        set.add("1");
        set.add("6");
        for (String s : set) {
            System.out.println(s);
        }
    }
}
