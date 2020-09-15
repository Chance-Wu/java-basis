package com.chance.java8.lambda;

/**
 * <p>
 * ApplePredicate接口的实现（选出重的苹果）
 * <p>
 *
 * @author chance
 * @since 2020-02-11
 */
public class AppleHeavyWeightPredicate implements ApplePredicate {

    @Override
    public boolean test(FilteringApples.Apple apple) {
        return apple.getWeight() > 150;
    }
}
