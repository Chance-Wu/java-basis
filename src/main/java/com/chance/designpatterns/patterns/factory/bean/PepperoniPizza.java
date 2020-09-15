package com.chance.designpatterns.patterns.factory.bean;

/**
 * <p>
 *
 * <p>
 *
 * @author chance
 * @since 2020-02-24
 */
public class PepperoniPizza implements Pizza{

    @Override
    public void prepare() {
        System.out.println("Pepperoni准备");
    }

    @Override
    public void bake() {
        System.out.println("Pepperoni烘烤");
    }

    @Override
    public void cut() {
        System.out.println("Pepperoni切片");
    }

    @Override
    public void box() {
        System.out.println("Pepperoni装盒");
    }
}
