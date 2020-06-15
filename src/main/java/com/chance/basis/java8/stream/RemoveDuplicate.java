package com.chance.basis.java8.stream;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * <p>
 * Stream是Java 8中处理集合的关键抽象概念
 * 它可以指定你希望对集合进行的操作，可以执行非常复杂的查找、过滤和映射数据等操作。
 * 使用Stream API对集合数据进行操作，就类似于使用SQL执行的数据库查询。
 * 也可以使用Stream API来并行执行操作。简而言之，Stream API提供了一种高效且易于使用的处理数据的方式。
 * <p>
 *
 * @author chance
 * @since 2020-06-06
 */
public class RemoveDuplicate {

    /**
     * JDK 1.8 Stream中对List进行去重
     * list.stream.distinct();
     */
    public static void removeDuplicate6() {
        List<String> a = new ArrayList<>();
        a.add("a");
        a.add("b");
        a.add("b");
        List<String> b = new ArrayList<>();
        b.add("a");
        b.add("c");
        b.add("b");
        a.addAll(b);
        List list = a
                .stream()
                .distinct()
                .collect(toList());
        System.out.println(list);
    }
}
