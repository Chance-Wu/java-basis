package com.chance.designpatterns.patterns.abstractdocument.domain;

import com.chance.designpatterns.patterns.abstractdocument.Document;

import java.util.stream.Stream;

/**
 * <p>
 *
 * <p>
 *
 * @author chance
 * @since 2020-06-18
 */
public interface HasParts extends Document {

    String PROPERTY = "parts";

    default Stream<Part> getParts() {
        return children(PROPERTY, Part::new);
    }
}
