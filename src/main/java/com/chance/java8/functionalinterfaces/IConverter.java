package com.chance.java8.functionalinterfaces;

/**
 * <p>
 * 函数式接口
 * <p>
 *
 * @author chance
 * @since 2020-09-16
 */
@FunctionalInterface
public interface IConverter<F, T> {

    T convert(F from);
}
