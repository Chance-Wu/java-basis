package com.chance.basis.concurrency;

/**
 * <p>
 *
 * <p>
 *
 * @author chance
 * @since 2020-07-11
 */
public class Singleton {

    public static volatile Singleton singleton;

    private Singleton() {
    }

    public static Singleton getInstance() {
        if (singleton == null) {
            synchronized (singleton) {
                if (singleton == null) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }
}
