package com.chance.basis.innerclass;

/**
 * @Description: Bird
 * @Author: chance
 * @Date: 2020-10-31 14:59
 * @Version 1.0
 */
public abstract class Bird {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract int fly();
}
