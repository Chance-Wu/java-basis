package com.chance.designpatterns.patterns.test;

import com.chance.designpatterns.patterns.decorator.Decorator;
import com.chance.designpatterns.patterns.decorator.SquarePeg;

/**
 * @Description: TestDecorator
 * @Author: chance
 * @Date: 12/28/20 4:50 PM
 * @Version 1.0
 */
public class TestDecorator {

    public static void main(String[] args) {
        SquarePeg squarePeg = new SquarePeg();
        Decorator decorator = new Decorator(squarePeg);
        decorator.insert();
    }
}
