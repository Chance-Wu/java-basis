package com.chance.designpatterns.patterns.template;

/**
 * @Description: 人生的抽象模板
 * @Author: chance
 * @Date: 2020-09-23 08:48
 * @Version 1.0
 */
public abstract class AbstractPeople {

    /**
     * 声明final方法不让子类覆盖
     */
    public final void life() {
        System.out.println("人的一生：");
        learn();
        work();
        love();
    }

    /**
     * 学习
     */
    protected abstract void learn();

    /**
     * 工作
     */
    protected abstract void work();

    /**
     * 恋爱
     */
    protected abstract void love();
}
