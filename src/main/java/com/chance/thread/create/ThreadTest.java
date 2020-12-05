package com.chance.thread.create;

/**
 * <p>
 * 创建线程
 * 方式一：继承Thread接口
 * <p>
 *
 * @author chance
 * @since 2020-01-19
 */
public class ThreadTest extends Thread {

    public ThreadTest() {
        super.setName("ThreadTest");
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println("来自线程" + Thread.currentThread().getName());
        }
    }
}
