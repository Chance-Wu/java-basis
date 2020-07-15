package com.chance.basis.thread.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * <p>
 * 测试tryLock()方法，如果获取锁的时候锁被占用就返回false，否则返回true
 * <p>
 *
 * @author chance
 * @since 2020-07-13
 */
public class TryLockTest {
    private Lock lock = new ReentrantLock();

    /**
     * 需要参与同步的方法
     */
    private void method(Thread thread) {
        if (lock.tryLock()) {
            try {
                System.out.println("线程名" + thread.getName() + "获得了锁");
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                System.out.println("线程名" + thread.getName() + "释放了锁");
                lock.unlock();
            }
        } else {
            System.out.println("我是" + Thread.currentThread().getName() + "有人占着锁，我就不要啦");
        }
    }

    public static void main(String[] args) {
        TryLockTest tryLockTest = new TryLockTest();

        //线程1
        Thread t1 = new Thread(() -> tryLockTest.method(Thread.currentThread()), "t1");

        Thread t2 = new Thread(() -> tryLockTest.method(Thread.currentThread()), "t2");

        t1.start();
        t2.start();
    }
}
