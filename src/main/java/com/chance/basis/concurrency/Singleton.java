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

    /**
     * 在变量singleton之间加上volatile关键字。
     * 先要了解对象的构造过程，实例化一个对象其实可以分为三个步骤:
     *  分配内存空间
     *  初始化对象
     *  将内存空间的地址赋值给对应的引用
     *
     * 操作系统可以对指令进行重排序，多线程环境下就可能将一个未初始化的对象引用暴露出来，从而导致不可预料的结果。
     */
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
