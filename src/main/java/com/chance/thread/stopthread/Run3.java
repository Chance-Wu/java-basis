package com.chance.thread.stopthread;

/**
 * <p>
 *
 * <p>
 *
 * @author chance
 * @since 2020-07-02
 */
public class Run3 {

    public static void main(String[] args) {
        MyThread thread = new MyThread();
        thread.start();
        thread.interrupt();
        System.out.println("Stop 1??" + thread.isInterrupted());
        System.out.println("Stop 2??" + thread.isInterrupted());
    }
}
