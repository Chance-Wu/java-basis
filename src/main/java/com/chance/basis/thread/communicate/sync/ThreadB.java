package com.chance.basis.thread.communicate.sync;

/**
 * <p>
 *
 * <p>
 *
 * @author chance
 * @since 2020-06-30
 */
public class ThreadB extends Thread {

    private MyObject object;

    @Override
    public void run() {
        super.run();
        object.methodB();
    }

    public ThreadB(MyObject object) {
        this.object = object;
    }
}
