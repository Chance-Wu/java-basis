package com.chance.basis.annotation;

import java.lang.reflect.Method;

/**
 * <p>
 *
 * <p>
 *
 * @author chance
 * @since 2020-09-03
 */
public class AnnotationTest {

    @Hello("hello")
    public static void main(String[] args) throws NoSuchMethodException {

        Class cls = AnnotationTest.class;
        Method method = cls.getMethod("main", String[].class);
        Hello hello = method.getAnnotation(Hello.class);
        System.out.println(hello);
    }
}
