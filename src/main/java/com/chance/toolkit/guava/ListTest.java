package com.chance.toolkit.guava;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: ListTest
 * @Author: chance
 * @Date: 2020-10-23 09:39
 * @Version 1.0
 */
public class ListTest {

    public static void main(String[] args) {
        List<Object> list = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            list.add(i);
        }
        // 将list集合按指定长度进行切分，返回新的List<List<??>>集合
        List<List<Object>> partition = Lists.partition(list, 10);
        System.out.println(partition.size());
        System.out.println(partition.get(0));
    }
}
