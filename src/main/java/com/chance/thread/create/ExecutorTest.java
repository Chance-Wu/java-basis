package com.chance.thread.create;

import java.util.concurrent.*;

/**
 * <p>
 * 创建线程
 * 方式三：使用Executor框架来创建线程池
 * <p>
 *
 * @author chance
 * @since 2020-01-20
 */
public class ExecutorTest {

    public static void main(String[] args) {
        // 创建线程池
        ExecutorService threadPool = Executors.newFixedThreadPool(10);
        while (true) {
            // 提交多个线程任务，并执行
            threadPool.execute(() -> {
                System.out.println(Thread.currentThread().getName() + " is running ..");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
    }
}
