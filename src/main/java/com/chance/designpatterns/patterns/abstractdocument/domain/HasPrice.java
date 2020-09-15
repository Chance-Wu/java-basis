package com.chance.designpatterns.patterns.abstractdocument.domain;

import com.chance.patterns.abstractdocument.Document;

import java.util.Optional;

/**
 * <p>
 *
 * <p>
 *
 * @author chance
 * @since 2020-06-18
 */
public interface HasPrice extends Document {

    String PROPERTY = "price";

    default Optional<Number> getPrice() {
        return Optional.ofNullable((Number) get(PROPERTY));
    }
}
