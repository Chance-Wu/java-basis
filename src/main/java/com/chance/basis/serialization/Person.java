package com.chance.basis.serialization;

import com.chance.basis.entity.Car;

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

    private Car car;

    public Person(String name, int age, Car car) {
        this.name = name;
        this.age = age;
        this.car = car;
    }

    @Override
    public String toString() {
        return "姓名：" + this.name + ", age=" + this.age+ ", car=" + this.car;
    }
}
