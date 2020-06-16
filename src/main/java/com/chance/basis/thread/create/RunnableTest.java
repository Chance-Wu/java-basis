package com.chance.basis.thread.create;

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

    /**
     * 重写run方法，线程执行体
     */
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            // 当线程类实现Runnable接口时，
            // 如果想获取当前线程，只能用Thread.currentThread()方法。
            System.out.println(Thread.currentThread().getName() + "  " + i);
        }
    }

    public static void main(String[] args) {
        RunnableTest thread = new RunnableTest();
        // 通过new Thread(target , name)方法创建新线程
        new Thread(thread, "新线程1").start();
        new Thread(thread, "新线程2").start();
    }
}
