package com.chance.basis.thread.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * <p>
 * ReentrantLock是Lock接口的实现
 *
 * 测试lock()方法，获取锁，如果锁被占用则一直等待
 * <p>
 *
 * @author chance
 * @since 2020-07-13
 */
public class LockTest {

    private Lock lock = new ReentrantLock();

    /**
     * 需要参与同步的方法
     */
    private void method(Thread thread) {
        lock.lock();
        try {
            System.out.println("线程名" + thread.getName() + "获得了锁");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
            System.out.println("线程名" + thread.getName() + "释放了锁");
        }
    }

    public static void main(String[] args) {
        LockTest lockTest = new LockTest();

        //线程t1
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                lockTest.method(Thread.currentThread());
            }
        }, "t1");

        //线程t2
        Thread t2 = new Thread(() -> lockTest.method(Thread.currentThread()), "t2");

        t1.start();
        t2.start();
    }
}
