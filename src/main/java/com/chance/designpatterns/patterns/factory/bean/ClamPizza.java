package com.chance.designpatterns.patterns.factory.bean;

/**
 * <p>
 *
 * <p>
 *
 * @author chance
 * @since 2020-02-24
 */
public class ClamPizza implements Pizza {

    @Override
    public void prepare() {
        System.out.println("Clam准备");
    }

    @Override
    public void bake() {
        System.out.println("Clam烘烤");
    }

    @Override
    public void cut() {
        System.out.println("Clam切片");
    }

    @Override
    public void box() {
        System.out.println("Clam装盒");
    }
}
