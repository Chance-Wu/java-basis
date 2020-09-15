package com.chance.java8.lambda;

/**
 * <p>
 * ApplePredicate接口的实现（选出绿苹果）
 * <p>
 *
 * @author chance
 * @since 2020-02-11
 */
public class AppleGreenColorPredicate implements ApplePredicate {

    @Override
    public boolean test(FilteringApples.Apple apple) {
        return "green".equals(apple.getColor());
    }
}
