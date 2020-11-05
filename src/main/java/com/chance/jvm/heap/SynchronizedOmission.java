package com.chance.jvm.heap;

/**
 * @Description: 同步省略
 * @Author: chance
 * @Date: 2020-11-04 14:45
 * @Version 1.0
 */
public class SynchronizedOmission {

    public void f() {
        Object hollis = new Object();
        // 对hollis这个对象加锁
        // hollis对象的生命周期只在f()方法中，并不会被其他线程锁访问到，所以在JIT编译阶段就会取消这部分代码的同步
        synchronized(hollis) {
            System.out.println(hollis);
        }
    }
}
