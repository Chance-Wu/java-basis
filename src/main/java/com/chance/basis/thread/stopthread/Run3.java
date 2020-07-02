package com.chance.basis.thread.stopthread;

/**
 * <p>
 * interrupt()方法的使用效果并不像for+break语句那样，马上就停止循环。
 * 调用interrupt方法是在当前线程中打了一个停止标志，并不是真的停止线程。
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
