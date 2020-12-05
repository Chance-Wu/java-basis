package com.chance.basis.annotation;

import java.lang.annotation.*;

/**
 * <p>
 *
 * <p>
 *
 * @author chance
 * @since 2020-09-13
 */
@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface CustomAnnotation {

    /**
     * 返回name，默认值为""
     *
     * @return
     */
    String name() default "";

    /**
     * 返回id，默认值为0
     *
     * @return
     */
    int id() default 0;
}
