package com.chance.thread.concurrency;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description: ReentrantLockTest
 * @Author: chance
 * @Date: 2020-10-27 15:23
 * @Version 1.0
 */
public class ReentrantLockTest {

    private Lock lock = new ReentrantLock();
//    private Lock fairSync = new ReentrantLock(true); // 公平锁
//    private Lock nonfairSync = new ReentrantLock(false); // 非公平锁

    /**
     * 创建Condition
     */
    private Condition condition = lock.newCondition();

    public void testMethod() {
        //lock 加锁
        lock.lock();
        try {
            //1、wait 方法等待：
            condition.await();
            //通过创建 Condition 对象来使线程 wait，必须先执行 lock.lock 方法获得锁
            //2、signal 方法唤醒
            condition.signal();//condition 对象的 signal 方法可以唤醒 wait 线程
            for (int i = 0; i < 5; i++) {
                System.out.println("ThreadName=" + Thread.currentThread().getName() + (" " + (i + 1)));
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
