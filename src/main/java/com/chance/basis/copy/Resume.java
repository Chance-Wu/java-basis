package com.chance.basis.copy;

/**
 * @Description: 浅拷贝
 * @Author: chance
 * @Date: 2020-11-02 09:52
 * @Version 1.0
 */
public class Resume implements Cloneable {

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
