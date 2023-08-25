package com.chance.designpatterns.patterns.bridge;

/**
 * <p> 抽象化角色 </p>
 *
 * @author chance
 * @date 2023/8/23 13:22
 * @since 1.0
 */
public abstract class Abstraction {

    protected Implementor imple;

    protected Abstraction(Implementor imple) {
        this.imple = imple;
    }

    public abstract void operation();
}
