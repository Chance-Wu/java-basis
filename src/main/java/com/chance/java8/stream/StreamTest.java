package com.chance.java8.stream;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Optional;

/**
 * <p>
 *
 * <p>
 *
 * @author chance
 * @since 2020-09-16
 */
public class StreamTest {

    @Test
    public void test() {
        ArrayList<String> stringCollection = new ArrayList<>();
        stringCollection.add("ddd2");
        stringCollection.add("aaa2");
        stringCollection.add("bbb2");
        stringCollection.add("aaa1");
        stringCollection.add("bbb3");
        stringCollection.add("ccc");
        stringCollection.add("bbb2");
        stringCollection.add("ddd1");
        if (stringCollection.size() > 0) {

            // filter过滤
            stringCollection.stream()
                    .filter(s -> s.startsWith("a"))
                    .forEach(System.out::println);

            // sorted排序
            stringCollection.stream()
                    .sorted()
                    .filter(s -> s.startsWith("a"))
                    .forEach(System.out::println);

            // map转换
            stringCollection.stream()
                    .map(String::toUpperCase)
                    .sorted(Comparator.reverseOrder())
                    .forEach(System.out::println);

            // map转换
            stringCollection.stream()
                    .map(String::toUpperCase)
                    .sorted(Comparator.reverseOrder())
                    .forEach(System.out::println);

            // match匹配
            // 验证list中string是否有以a开头的，匹配到第一个即返回true
            boolean anyStrartsWithA = stringCollection.stream()
                    .anyMatch(s -> s.startsWith("a"));

            // 验证list中string是否都是以a开头的
            boolean allStrartsWithA = stringCollection.stream()
                    .anyMatch(s -> s.startsWith("a"));

            // 验证list中string是否都不是以z开头的
            boolean noneStrartsWithA = stringCollection.stream()
                    .noneMatch(s -> s.startsWith("z"));

            // count计数
            long startsWithB = stringCollection.stream()
                    .filter(s -> s.startsWith("b"))
                    .count();

            // reduce
            Optional<String> reduced = stringCollection.stream()
                    .sorted()
                    .reduce((s1, s2) -> s1 + "#" + s2);
            reduced.ifPresent(System.out::println);
        }
    }
}
