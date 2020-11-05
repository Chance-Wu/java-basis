package com.chance.jvm;

/**
 * <p>
 * 线程可见性问题
 * <p>
 *
 * @author chance
 * @since 2020-03-01
 */
public class NoVisibility implements Runnable {

    private static boolean ready = false;
    private static int num = 111;

    @Override
    public void run() {
        while (!ready) {
            Thread.yield();
        }
        System.out.println(num);
    }

    public static void main(String[] args) {
        NoVisibility task = new NoVisibility();
        new Thread(task).start();
        ready = true;
        num = 13;
    }
}
