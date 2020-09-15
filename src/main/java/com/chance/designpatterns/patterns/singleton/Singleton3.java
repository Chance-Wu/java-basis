package com.chance.designpatterns.patterns.singleton;

/**
 * <p>
 * Holder模式
 * <p>
 * 核心是静态变量，足够方便和线程安全;
 * 通过静态的Holder类持有真正实例，间接实现了懒加载。
 * <p>
 *
 * @author chance
 * @since 2020-01-14
 */
public class Singleton3 {

    /**
     * 类级内部类，也就是静态的成员内部类，该内部类的实例与外部类的实例没有绑定关系
     * 只有被调用时才会装载，从而实现了延迟加载。
     */
    private static class SingletonHolder {
        //静态初始化器，由JVM来保证线程安全
        private static final Singleton3 singleton = new Singleton3();
    }

    public static Singleton3 getInstance() {
        return SingletonHolder.singleton;
    }
}
