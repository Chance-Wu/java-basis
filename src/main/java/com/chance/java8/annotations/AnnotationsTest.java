package com.chance.java8.annotations;

import org.junit.Test;

/**
 * <p>
 *
 * <p>
 *
 * @author chance
 * @since 2020-09-16
 */
public class AnnotationsTest {

    @Test
    public void test() {
        @Hints({@Hint("hint1"), @Hint("hint2")})
        class Person {
        }
    }


    @Test
    public void test41() {
        @Hint("hint1")
        @Hint("hint2")
        class Person {
        }
    }
}
