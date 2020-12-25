package com.chance.designpatterns.patterns.adapter;

/**
 * @Description: WildTurkey
 * @Author: chance
 * @Date: 12/21/20 12:10 PM
 * @Version 1.0
 */
public class WildTurkey implements Turkey {
    @Override
    public void gobble() {
        System.out.println("Gobble gobble");
    }

    @Override
    public void fly() {
        System.out.println("I'am flying a short distance");
    }
}
