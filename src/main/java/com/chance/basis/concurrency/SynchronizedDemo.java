package com.chance.basis.concurrency;

/**
 * <p>
 *
 * <p>
 *
 * @author chance
 * @since 2020-07-11
 */
public class SynchronizedDemo {

    public void method() {
        synchronized (this) {
            System.out.println("Method 1 start");
        }
    }
}
