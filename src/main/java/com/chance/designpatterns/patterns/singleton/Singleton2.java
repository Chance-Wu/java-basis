package com.chance.designpatterns.patterns.singleton;

/**
 * <p>
 * 饿汉模式：即类加载时初始化单例，以后访问时直接返回即可
 *
 * 线程安全
 * <p>
 *
 * @author chance
 * @since 2020-01-14
 */
public class Singleton2 {

    private static final Singleton2 singleton = new Singleton2();

    private Singleton2() {
    }

    public static Singleton2 getInstance() {
        return singleton;
    }
}
