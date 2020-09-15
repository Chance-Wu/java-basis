package com.chance.designpatterns.patterns.factory.bean;

/**
 * <p>
 * Pizza接口
 * <p>
 *
 * @author chance
 * @since 2020-02-24
 */
public interface Pizza {

    /**
     * 定义默认实现的方法
     */
    default void prepare() {
        System.out.println("准备");
    }

    default void bake() {
        System.out.println("烘烤");
    }

    default void cut() {
        System.out.println("切片");
    }

    default void box() {
        System.out.println("装盒");
    }
}
