package com.chance.thread.sync;

/**
 * <p>
 *
 * <p>
 *
 * @author chance
 * @since 2020-07-13
 */
public class SyncDemo {

    public void sync() {
        synchronized (SyncDemo.class) {
            System.out.println();
        }
    }
}
