package com.chance.basis.serialization;

import java.io.Serializable;

/**
 * <p>
 *
 * <p>
 *
 * @author chance
 * @since 2020-02-05
 */
public class Person implements Serializable {

    private String name;

    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "姓名：" + this.name + ", age=" + this.age;
    }
}
