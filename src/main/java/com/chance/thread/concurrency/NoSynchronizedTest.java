package com.chance.thread.concurrency;

/**
 * <p>
 * 没有同步的情况
 * <p>
 *
 * @author chance
 * @since 2020-07-11
 */
public class NoSynchronizedTest {

    /**
     * 没有同步的情况
     */
    public void method1() {
        System.out.println("Method 1 start");
        try {
            System.out.println("Method 1 execute");
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Method 1 end");
    }

    public void method2() {
        System.out.println("Method 2 start");
        try {
            System.out.println("Method 2 execute");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Method 2 end");
    }

    public static void main(String[] args) {
        final NoSynchronizedTest test = new NoSynchronizedTest();

        new Thread(() -> test.method1()).start();

        new Thread(() -> test.method2()).start();
    }
}
