package com.chance.designpatterns.patterns.composite;

/**
 * @Description: Component
 * @Author: chance
 * @Date: 12/25/20 1:44 PM
 * @Version 1.0
 */
public abstract class Component {

    protected String name;

    public Component(String name) {
        this.name = name;
    }

    /**
     * 通常都用 add和remove方法来提供增加或移除树叶或树枝的功能
     */
    public abstract void add(Component c);

    public abstract void remove(Component c);

    public abstract void display(int depth);
}
