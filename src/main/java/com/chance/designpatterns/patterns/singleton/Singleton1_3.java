package com.chance.designpatterns.patterns.singleton;

/**
 * <p>
 * 饱汉-变种3
 *
 * 适用于多线程环境下
 * <p>
 *
 * @author chance
 * @since 2020-01-14
 */
public class Singleton1_3 {

    private static volatile Singleton1_3 singleton = null;

    private int f1 = 1;
    private int f2 = 2;

    private Singleton1_3() {
    }

    public static Singleton1_3 getInstance() {
        if (singleton == null) {
            //must be a complete instance
            synchronized (Singleton1_3.class) {
                if (singleton == null) {
                    singleton = new Singleton1_3();
                }
            }
        }
        return singleton;
    }
}
