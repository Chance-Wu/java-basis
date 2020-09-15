package com.chance.designpatterns.patterns.factory.bean;

/**
 * <p>
 *
 * <p>
 *
 * @author chance
 * @since 2020-02-24
 */
public class VeggiePizza implements Pizza {

    @Override
    public void prepare() {
        System.out.println("Veggie准备");
    }

    @Override
    public void bake() {
        System.out.println("Veggie烘烤");
    }

    @Override
    public void cut() {
        System.out.println("Veggie切片");
    }

    @Override
    public void box() {
        System.out.println("Veggie装盒");
    }
}
