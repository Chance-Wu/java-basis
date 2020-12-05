package com.chance.basis.copy;

/**
 * @Description: Professor
 * @Author: chance
 * @Date: 2020-11-02 10:05
 * @Version 1.0
 */
public class Professor {

    private String name;

    @Override
    public Object clone() {
        try {
            return super.clone();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
