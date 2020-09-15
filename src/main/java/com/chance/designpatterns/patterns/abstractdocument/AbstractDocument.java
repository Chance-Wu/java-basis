package com.chance.designpatterns.patterns.abstractdocument;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Stream;

/**
 * <p>
 * Abstract the base class to provide a collection of storage attributes
 * 抽象出基类，提供存储属性的集合
 * <p>
 *
 * @author chance
 * @since 2020-06-18
 */
public class AbstractDocument implements Document {

    private final Map<String, Object> properties;

    public AbstractDocument(Map<String, Object> properties) {
        // 判断当前对象是否为空，为空会抛出一个空指针异常
        Objects.requireNonNull(properties, "properties map is required");
        this.properties = properties;
    }

    @Override
    public void put(String key, Object value) {
        properties.put(key, value);
    }

    @Override
    public Object get(String key) {
        return properties.get(key);
    }

    @Override
    public <T> Stream<T> children(String key, Function<Map<String, Object>, T> constructor) {
        Optional<List<Map<String, Object>>> any = Stream.of(get(key))
                .filter(el -> el != null)
                .map(el -> (List<Map<String, Object>>) el)
                .findAny();
        return any.isPresent() ? any.get().stream().map(constructor) : Stream.empty();
    }

    @Override
    public String toString() {
        return "AbstractDocument{" +
                "properties=" + properties +
                '}';
    }
}
