package com.chance.designpatterns.patterns.abstractdocument;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Stream;

/**
 * <p>
 * Define put and get methods through the interface
 * 通过接口定义存储和获取属性的方法
 * <p>
 *
 * @author chance
 * @since 2020-06-18
 */
public interface Document {

    void put(String key, Object value);

    Object get(String key);

    <T> Stream<T> children(String key, Function<Map<String, Object>, T> constructor);
}
