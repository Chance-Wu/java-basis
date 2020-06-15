package com.chance.basis.java8.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 流的扁平化
 * <p>
 * .flatMap()
 * <p>
 *
 * @author chance
 * @since 2020-06-08
 */
public class FlatStream {

    public static void main(String[] args) {

        List<String> words = new ArrayList<>();
        words.add("Hello");
        words.add("World");
        List<String> uniqueCharacters = words.stream()
                .map(w -> w.split(""))
                .flatMap(Arrays::stream)// 将各个生成流扁平化为单个流
                .distinct()
                .collect(Collectors.toList());

        System.out.println(uniqueCharacters);
    }
}
