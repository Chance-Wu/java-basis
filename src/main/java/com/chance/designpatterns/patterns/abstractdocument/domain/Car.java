package com.chance.designpatterns.patterns.abstractdocument.domain;

import com.chance.designpatterns.patterns.abstractdocument.AbstractDocument;

import java.util.Map;

/**
 * <p>
 *
 * <p>
 *
 * @author chance
 * @since 2020-06-18
 */
public class Car extends AbstractDocument implements HasModel,HasPrice,HasParts {


    public Car(Map<String, Object> properties) {
        super(properties);
    }
}
