package com.chance.designpatterns.patterns.adapter;

/**
 * @Description: MallardDuck
 * @Author: chance
 * @Date: 12/21/20 12:09 PM
 * @Version 1.0
 */
public class MallardDuck implements Duck {
    @Override
    public void quack() {
        System.out.println("QUACK");
    }

    @Override
    public void fly() {
        System.out.println("I'am flying");
    }
}
