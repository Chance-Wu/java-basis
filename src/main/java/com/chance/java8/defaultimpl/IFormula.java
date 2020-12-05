package com.chance.java8.defaultimpl;

/**
 * <p>
 *
 * <p>
 *
 * @author chance
 * @since 2020-09-16
 */
public interface IFormula {

    double calculate(int a);

    /**接口中的默认实现*/
    default double sqrt(int a) {
        return Math.sqrt(a);
    }
}
