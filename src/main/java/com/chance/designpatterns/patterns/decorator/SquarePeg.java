package com.chance.designpatterns.patterns.decorator;

/**
 * @Description: SquarePeg
 * @Author: chance
 * @Date: 12/28/20 4:31 PM
 * @Version 1.0
 */
public class SquarePeg implements Work {

    @Override
    public void insert() {
        System.out.println("方形桩插入");
    }
}
