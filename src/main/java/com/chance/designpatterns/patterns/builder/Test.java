package com.chance.designpatterns.patterns.builder;

/**
 * <p>
 *
 * <p>
 *
 * @author chance
 * @since 2020-06-09
 */
public class Test {

    public static void main(String[] args) {
        PersonBuilder personBuilder = new PersonBuilder.Builder(1, "张三")
                .age(22)
                .sex("男")
                .desc("使用builder模式")
                .build();

        System.out.println(personBuilder.toString());

    }
}
