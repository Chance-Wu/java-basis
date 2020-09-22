package com.chance.designpatterns.patterns.singleton;

/**
 * <p>
 * 饱汉-变种1
 *
 * 使用synchronized关键字修饰getInstance()方法，达到绝对的线程安全
 *
 * synchronized方法带来极大的cpu开销
 * <p>
 *
 * @author chance
 * @since 2020-01-14
 */
public class Singleton1_1 {

    private static Singleton1_1 singleton = null;

    private Singleton1_1() {
    }

    public synchronized static Singleton1_1 getInstance() {
        if (singleton == null) {
            singleton = new Singleton1_1();
        }
        return singleton;
    }
}
