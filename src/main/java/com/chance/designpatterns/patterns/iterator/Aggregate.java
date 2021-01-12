package com.chance.designpatterns.patterns.iterator;

import java.util.Iterator;

/**
 * @Description: 只有实现此接口才可以获得迭代器对象
 * @Author: chance
 * @Date: 1/3/21 11:48 PM
 * @Version 1.0
 */
public interface Aggregate<E> {

    /**
     * 获得迭代器
     */
    Iterator<E> iterator();
}
