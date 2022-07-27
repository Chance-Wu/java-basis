package com.chance.basis.annotation;

/**
 * @author: chance
 * @date: 2022/7/8 13:57
 * @since: 1.0
 */
public class DemoValue {

    @Bind(value = 1)
    int value;

    public int sayHello(int n) {
        return value;
    }
}
