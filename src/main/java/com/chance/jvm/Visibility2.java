package com.chance.jvm;

/**
 * <p>
 * 线程可见性问题解决方案
 * 使用volatile关键字
 * <p>
 *
 * @author chance
 * @since 2020-03-01
 */
public class Visibility2 implements Runnable {

    private static volatile boolean ready = false;
    private static volatile int num = 111;

    @Override
    public void run() {
        while (!ready) {
            Thread.yield();
        }
        System.out.println(num);
    }

    public static void main(String[] args) {
        Visibility2 task = new Visibility2();
        new Thread(task).start();
        ready = true;
        num = 13;
    }
}
