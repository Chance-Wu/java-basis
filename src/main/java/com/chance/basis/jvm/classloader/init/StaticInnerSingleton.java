package com.chance.basis.jvm.classloader.init;

/**
 * <p>
 *
 * <p>
 *
 * @author chance
 * @since 2020-07-02
 */
public class StaticInnerSingleton {

    /**
     * 使用静态内部类实现单例：
     * 1：线程安全
     * 2：懒加载
     * 3：非反序列化安全，即反序列化得到的对象与序列化时的单例对象不是同一个，违反单例原则
     */
    private static class LazyHolder {
        private static final StaticInnerSingleton INNER_SINGLETON = new StaticInnerSingleton();
    }

    private StaticInnerSingleton() {
    }

    public static StaticInnerSingleton getInstance() {
        return LazyHolder.INNER_SINGLETON;
    }
}
