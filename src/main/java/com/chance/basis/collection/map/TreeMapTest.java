package com.chance.basis.collection.map;

import java.util.TreeMap;

/**
 * <p>
 *
 * <p>
 *
 * @author chance
 * @since 2020-08-05
 */
public class TreeMapTest {

    public static void main(String[] args) {
        TreeMap<String, String> treeMap = new TreeMap<>();
        treeMap.put("f","a");
        treeMap.put("a","a");
        treeMap.put("d","a");
        treeMap.put("c","a");
        treeMap.put("b","a");
        treeMap.put("2","a");
        treeMap.put("1","a");

        String a = treeMap.get("a");
        System.out.println(a);

        treeMap.remove("c");


        System.out.println(treeMap);

    }
}
