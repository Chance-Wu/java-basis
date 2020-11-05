package com.chance.basis.generic;

/**
 * @Description: 泛型类
 * @Author: chance
 * @Date: 2020-11-02 09:15
 * @Version 1.0
 */
public class GenericClass<T> {

    private T t;

    public void add(T t) {
        this.t = t;
    }

    public T get() {
        return t;
    }
}
