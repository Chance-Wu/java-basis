package com.chance.java8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * <p>
 * 流只能遍历一次
 *
 * 遍历完之后，我们就说这个流已经被消费掉了
 * <p>
 *
 * @author chance
 * @since 2020-06-08
 */
public class TraverseStream {

    public static void main(String[] args) {
        List<String> title = Arrays.asList("Java 8", "In", "Action");
        Stream<String> s = title.stream();
        s.forEach(System.out::println);

        // 可以从原始数据源那里再获得一个新的流来重新遍历一遍
        Stream<String> s2 = title.stream();
        s2.forEach(System.out::println);
    }
}
