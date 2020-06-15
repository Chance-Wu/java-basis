package com.chance.basis.reflection.proxy;

/**
 * <p>
 *
 * <p>
 *
 * @author chance
 * @since 2020-02-20
 */
public class RealSubject implements Subject {
    @Override
    public void rent() {
        System.out.println("I want to rent my house");
    }

    @Override
    public void hello(String str) {
        System.out.println("hello:" + str);
    }
}
