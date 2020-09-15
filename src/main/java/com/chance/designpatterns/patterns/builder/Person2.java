package com.chance.designpatterns.patterns.builder;

import lombok.Builder;

/**
 * <p>
 *
 * <p>
 *
 * @author chance
 * @since 2020-06-09
 */
@Builder
public class Person2 {

    //必要参数

    private final int id;
    private final String name;

    //可选参数

    private int age;
    private String sex;
    private String phone;
    private String address;
    private String desc;
}
