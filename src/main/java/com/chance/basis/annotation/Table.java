package com.chance.basis.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author chance
 *
 * Target表示注解可以贴在哪些程序元素上面
 *
 * Retention表示注解可以保留到哪个阶段，一般自定义保留到RUNTIME运行时
 */
@Target(ElementType.ANNOTATION_TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Table {

    /**
     * 注解属性
     * 语法
     * 数据类型
     * 如果属性名称是value，在使用注解的时候，可以省略value
     *
     */
    String name();
}
