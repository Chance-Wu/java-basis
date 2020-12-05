package com.chance.thread.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * <p>
 * newCacheThreadPool
 * <p>
 *
 * @author chance
 * @since 2020-07-13
 */
public class NewCacheThreadPoolTest {

    public static void main(String[] args) {
        // 创建一个可缓存线程池
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            final int index = i;
            try {
                Thread.sleep(index * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // 使用线程池执行任务
            cachedThreadPool.execute(
                    () -> System.out.println(index)
            );

        }
    }
}