package com.chance.jvm;

/**
 * <p>
 * 线程可见性问题解决方案
 * 使用synchronized关键字
 * <p>
 *
 * @author chance
 * @since 2020-03-01
 */
public class Visibility1 implements Runnable {

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
        Visibility1 task = new Visibility1();
        new Thread(task).start();
        setReady(true);
        setNum(13);
    }

    public static synchronized void setReady(boolean ready) {
        Visibility1.ready = ready;
    }

    public static synchronized void setNum(int num) {
        Visibility1.num = num;
    }
}
