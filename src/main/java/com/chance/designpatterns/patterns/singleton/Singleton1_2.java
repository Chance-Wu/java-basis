package com.chance.designpatterns.patterns.singleton;

/**
 * <p>
 * 饱汉-变种2
 * <p>
 * DCL 1.0
 * 线程不安全，由于指令重排，可能会得到"半个对象"，即"部分初始化"问题
 * <p>
 *
 * @author chance
 * @since 2020-01-14
 */
public class Singleton1_2 {
    private static Singleton1_2 singleton = null;

    private int f1 = 1; // 触发部分初始化问题
    private int f2 = 2;

    private Singleton1_2() {
    }

    public static Singleton1_2 getInstance() {
        //当instance不为null时，可能指向一个“被部分初始化的对象”
        if (singleton == null) {
            synchronized (Singleton1_2.class) {
                // must be complete instance
                if (singleton == null) {
                    singleton = new Singleton1_2();
                }
            }
        }
        return singleton;
    }
}
