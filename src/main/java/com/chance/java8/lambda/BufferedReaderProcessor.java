package com.chance.java8.lambda;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * <p>
 * 函数式接口
 * <p>
 *
 * @author chance
 * @since 2020-02-13
 */
@FunctionalInterface
public interface BufferedReaderProcessor {

    String process(BufferedReader b) throws IOException;
}
