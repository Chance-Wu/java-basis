package com.chance.basis.collection.set2list;

import java.util.*;

/**
 * @Description: Set2List
 * @Author: chance
 * @Date: 1/8/21 1:24 PM
 * @Version 1.0
 */
public class Set2List {

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>(16);
        map.put("ele1", "小樱");
        map.put("ele2", "若曦");
        map.put("ele3", "晴川");
        Set<String> set = map.keySet();

        // 1.通过ArrayList的构造方法进行转换
        List<String> list1 = new ArrayList<>(set);
        for (int i = 0; i < list1.size(); i++) {
            System.out.println("list1(" + i + ") --> " + list1.get(i));
        }

        // 2.通过List实现类进行转换
        List<String> list2 = new ArrayList<>();
        list2.addAll(set);
        for (String elem : list2) {
            System.out.println(elem);
        }
    }
}
