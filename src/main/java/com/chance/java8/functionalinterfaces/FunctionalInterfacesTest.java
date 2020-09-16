package com.chance.java8.functionalinterfaces;

import org.junit.Test;

/**
 * <p>
 *
 * <p>
 *
 * @author chance
 * @since 2020-09-16
 */
public class FunctionalInterfacesTest {

    @Test
    public void test() {
        // 传统方式
        IConverter<String, Integer> converter01 = new IConverter<String, Integer>() {
            @Override
            public Integer convert(String from) {
                return Integer.valueOf(from);
            }
        };

        // 只有一个参数，括号可以不要
        IConverter<String, Integer> converter02 = (from) -> {
            return Integer.valueOf(from);
        };

        // 继续简化
        IConverter<String, Integer> converter03 = from -> Integer.valueOf(from);

        IConverter<String, Integer> converter04 = Integer::valueOf;
    }
}
