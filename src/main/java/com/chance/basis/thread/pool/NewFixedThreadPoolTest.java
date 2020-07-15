package com.chance.basis.thread.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * <p>
 * newFixedThreadPool
 *
 * 定长线程池的大小最好根据系统资源进行设置如Runtime.getRuntime().availableProcessors()
 * <p>
 *
 * @author chance
 * @since 2020-07-13
 */
public class NewFixedThreadPoolTest {

    public static void main(String[] args) {
        // 创建一个指定线程数量的线程池
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);
        System.out.println(Runtime.getRuntime().availableProcessors());
        for (int i = 0; i < 10; i++) {
            final int index = i;
            // 使用线程池执行任务
            fixedThreadPool.execute(
                () -> {
                    try {
                        System.out.println(index);
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            );
        }
    }
}
