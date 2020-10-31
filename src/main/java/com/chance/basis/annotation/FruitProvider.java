package com.chance.basis.annotation;

import java.lang.annotation.*;

/**
 * @Description: FruitProvider
 * @Author: chance
 * @Date: 2020-10-30 16:51
 * @Version 1.0
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface FruitProvider {

    /**
     * 供应商编号
     */
    int id() default -1;

    /**
     * 供应商名称
     */
    String name() default "";

    /**
     * 供应商地址
     */
    String address() default "";
}
