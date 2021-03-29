package com.chance.designpatterns.patterns.singleton;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @Description: CAS是一种基于忙等待的算法，依赖底层硬件的实现，相对于锁它没有线程切换和阻塞的额外消耗，可以支持较大的并行度。
 * @Author: chance
 * @Date: 3/29/21 9:49 AM
 * @Version 1.0
 */
public class Singleton5 {

    private static final AtomicReference<Singleton5> INSTANCE
            = new AtomicReference<>();

    private Singleton5() {
    }

    public static Singleton5 getInstance() {
        for (; ; ) {
            Singleton5 instance = INSTANCE.get();
            if (instance != null) {
                return instance;
            }
            instance = new Singleton5();
            if (INSTANCE.compareAndSet(null, instance)) {
                return instance;
            }
        }
    }
}
