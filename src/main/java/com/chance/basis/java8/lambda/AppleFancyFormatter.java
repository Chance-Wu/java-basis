package com.chance.basis.java8.lambda;

/**
 * <p>
 *
 * <p>
 *
 * @author chance
 * @since 2020-02-12
 */
public class AppleFancyFormatter implements AppleFormatter {
    @Override
    public String accept(FilteringApples.Apple apple) {
        String characteristic = apple.getWeight() > 150 ? "heavy" : "light";
        return "A " + characteristic + apple.getColor() + " apple";
    }
}
