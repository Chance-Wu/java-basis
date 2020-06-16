package com.chance.basis.thread;

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
    }

    /**
     * 重写run方法
     */
    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println("来自线程" + Thread.currentThread().getName());
        }
    }

    public static class Test {
        public static void main(String[] args) {
            ThreadTest thread1 = new ThreadTest();
            ThreadTest thread2 = new ThreadTest();
            //启动线程
            thread1.start();
            thread2.start();
        }
    }
}
