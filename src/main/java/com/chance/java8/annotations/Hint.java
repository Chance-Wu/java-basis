package com.chance.java8.annotations;

import java.lang.annotation.Repeatable;

/**
 * <p>
 *
 * <p>
 *
 * @author chance
 * @since 2020-09-16
 */
@Repeatable(Hints.class)
public @interface Hint {

    String value();
}
