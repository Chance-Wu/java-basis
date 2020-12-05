package com.chance.designpatterns.patterns.template;

/**
 * @Description: Son
 * @Author: chance
 * @Date: 2020-09-23 08:52
 * @Version 1.0
 */
public class Son extends AbstractPeople {
    @Override
    protected void learn() {
        System.out.println("学习的具体实现");
    }

    @Override
    protected void work() {
        System.out.println("工作的具体实现");
    }

    @Override
    protected void love() {
        System.out.println("爱情的具体实现");
    }
}
