package com.chance.thread.stopthread;

/**
 * <p>
 *
 * <p>
 *
 * @author chance
 * @since 2020-07-02
 */
public class MyThread extends Thread {

    @Override
    public void run() {
        super.run();
        int count = 500000;
        for (int i = 0; i < count; i++) {
            System.out.println("i=" + (i + 1));
        }
    }
}
