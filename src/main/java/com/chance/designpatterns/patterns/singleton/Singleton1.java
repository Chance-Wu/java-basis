package com.chance.designpatterns.patterns.singleton;

/**
 * <p>
 * 饱汉模式：懒加载。
 * <p>
 * 优点：启动速度快，一直到实例被第一次访问
 * 缺点：线程不安全，if语句存在竟态条件
 * <p>
 *
 * @author chance
 * @since 2020-01-14
 */
public class Singleton1 {

    private static Singleton1 singleton = null;

    /**
     * 私有
     */
    private Singleton1() {
    }

    /**
     * 获取实例的方法（必须是静态方法，常使用getInstance这个名称）
     */
    public static Singleton1 getInstance() {
        if (singleton == null) {
            singleton = new Singleton1();
        }
        return singleton;
    }
}
