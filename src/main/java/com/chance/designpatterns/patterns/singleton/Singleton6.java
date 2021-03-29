package com.chance.designpatterns.patterns.singleton;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description: 类似双重校验锁写法
 * @Author: chance
 * @Date: 3/29/21 9:56 AM
 * @Version 1.0
 */
public class Singleton6 {

    private static Singleton6 instance = null;
    private static Lock lock = new ReentrantLock();

    private Singleton6() {
    }

    public static Singleton6 getInstance() {
        if (instance == null) {
            lock.lock(); // 显式调用，手动加锁
            if (instance == null) {
                instance = new Singleton6();
            }
            lock.unlock(); // 显式调用，手动解锁
        }
        return instance;
    }
}
