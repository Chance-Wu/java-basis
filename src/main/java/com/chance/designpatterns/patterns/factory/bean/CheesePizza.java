package com.chance.designpatterns.patterns.factory.bean;

/**
 * <p>
 *
 * <p>
 *
 * @author chance
 * @since 2020-02-24
 */
public class CheesePizza implements Pizza {

    @Override
    public void prepare() {
        System.out.println("Cheese准备");
    }

    @Override
    public void bake() {
        System.out.println("Cheese烘烤");
    }

    @Override
    public void cut() {
        System.out.println("Cheese切片");
    }

    @Override
    public void box() {
        System.out.println("Cheese装盒");
    }
}
