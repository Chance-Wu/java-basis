package com.chance.java8.lambda;

/**
 * <p>
 *
 * <p>
 *
 * @author chance
 * @since 2020-02-12
 */
public class AppleSimpleFormatter implements AppleFormatter {
    @Override
    public String accept(FilteringApples.Apple apple) {
        return "An apple of " + apple.getWeight() + "g";
    }
}
