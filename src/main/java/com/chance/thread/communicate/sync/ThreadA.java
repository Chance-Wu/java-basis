package com.chance.thread.communicate.sync;

/**
 * <p>
 *
 * <p>
 *
 * @author chance
 * @since 2020-06-30
 */
public class ThreadA extends Thread {
    private MyObject object;

    @Override
    public void run() {
        super.run();
        object.methodA();
    }

    public ThreadA(MyObject object) {
        this.object = object;
    }
}
