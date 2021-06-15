package com.chance.thread.communicate.sync;

/**
 * <p>
 *
 * <p>
 *
 * @author chance
 * @since 2020-06-30
 */
public class MyObject {

    synchronized public void methodA() {
        System.out.println("执行A方法");
    }

    synchronized public void methodB() {
        System.out.println("执行B方法");
    }
}
