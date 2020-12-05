package com.chance.designpatterns.patterns.abstractdocument.domain;

import com.chance.designpatterns.patterns.abstractdocument.Document;

import java.util.Optional;

/**
 * <p>
 *
 * <p>
 *
 * @author chance
 * @since 2020-06-19
 */
public interface HasType extends Document {

    String PROPERTY = "type";

    default Optional<String> getType() {
        return Optional.ofNullable((String) get(PROPERTY));
    }
}
