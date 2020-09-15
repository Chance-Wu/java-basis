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
public interface HasModel extends Document {

    String PROPERTY = "model";

    default Optional<String> getModel() {
        return Optional.ofNullable((String) get(PROPERTY));
    }
}
