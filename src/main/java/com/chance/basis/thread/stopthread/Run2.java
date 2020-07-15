package com.chance.basis.thread.stopthread;

/**
 * <p>
 *
 * <p>
 *
 * @author chance
 * @since 2020-07-02
 */
public class Run2 {

    public static void main(String[] args) {
        Thread.currentThread().interrupt();
        System.out.println("Stop 1??" + Thread.interrupted());
        System.out.println("Stop 2??" + Thread.interrupted());

        System.out.println("End");
    }
}
