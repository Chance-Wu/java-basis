package com.chance.java8.defaultimpl;

/**
 * <p>
 * JDK 1.8之前，因为接口里只能做方法的定义不能有方法的实现，
 * 因此我们通常会在抽象类里面实现默认的方法（一般这个默认的方法是抽象后公用的方法，不需要每一个继承者都去实现，只需调用即可）
 * <p>
 *
 * @author chance
 * @since 2020-09-16
 */
public abstract class AFormula {

    abstract double calculate(int a);

    /**抽象类中的默认实现*/
    double sqrt(int a) {
        return Math.sqrt(a);
    }
}
