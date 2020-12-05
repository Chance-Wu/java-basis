package com.chance.basis.annotation;

/**
 * @Description: Apple
 * @Author: chance
 * @Date: 2020-10-30 16:57
 * @Version 1.0
 */
public class Apple {

    @FruitProvider(id = 1, name = "陕西红富士集团", address = "陕西省西安市延安路")
    private String appleProvider;

    public void setAppleProvider(String appleProvider) {
        this.appleProvider = appleProvider;
    }

    public String getAppleProvider() {
        return appleProvider;
    }
}
