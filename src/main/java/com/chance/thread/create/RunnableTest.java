package com.chance.thread.create;

/**
 * <p>
 * 创建线程
 * 方式二：实现Runnable接口
 * <p>
 *
 * @author chance
 * @since 2020-01-19
 */
public class RunnableTest implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            // 当线程类实现Runnable接口时，
            // 如果想获取当前线程，只能用Thread.currentThread()方法。
            System.out.println(Thread.currentThread().getName() + "  " + i);
        }
    }
}
