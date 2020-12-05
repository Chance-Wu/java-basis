package com.chance.java8.lambda;

/**
 * <p>
 * 定义一个接口来对选择标准建模
 * <p>
 *
 * @author chance
 * @since 2020-02-11
 */
public interface ApplePredicate {
    boolean test(FilteringApples.Apple apple);
}