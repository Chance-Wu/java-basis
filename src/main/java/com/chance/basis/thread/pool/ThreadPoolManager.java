package com.chance.basis.thread.pool;

import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * <p>
 *
 * <p>
 *
 * @author chance
 * @since 2020-07-14
 */
public class ThreadPoolManager {

    private static ThreadPoolConfig threadPool;


    /**
     * 获取单例的线程池对象
     */
    public static ThreadPoolConfig getThreadPool() {
        if (threadPool == null) {
            synchronized (ThreadPoolManager.class) {
                if (threadPool == null) {
                    // 获取处理器数量
                    int cpuNum = Runtime.getRuntime().availableProcessors();
                    // 根据cpu数量,计算出合理的线程并发数
                    int threadNum = cpuNum * 2 + 1;
                    System.out.println("cpu num:" + cpuNum);
                    threadPool = new ThreadPoolConfig(threadNum, threadNum, 0L);
                }
            }
        }
        return threadPool;
    }

    /**
     * 内部类
     */
    static class ThreadPoolConfig {

        private volatile int corePoolSize;
        private volatile int maximumPoolSize;
        private volatile long keepAliveTime;

        private ThreadPoolExecutor executor;

        private ThreadPoolConfig(int corePoolSize, int maximumPoolSize, long keepAliveTime) {
            this.corePoolSize = corePoolSize;
            this.maximumPoolSize = maximumPoolSize;
            this.keepAliveTime = keepAliveTime;
        }

        public void executor(Runnable runnable) {
            if (runnable == null) {
                return;
            }
            if (executor == null) {
                executor = new ThreadPoolExecutor(corePoolSize,
                        maximumPoolSize,
                        keepAliveTime,  //闲置线程存活时间
                        TimeUnit.MILLISECONDS,
                        new LinkedBlockingDeque<Runnable>(),    //线程队列
                        Executors.defaultThreadFactory(),   //线程工厂
                        new ThreadPoolExecutor.AbortPolicy()    //队列已满，而且当前线程数已经超过最大线程数时的异常处理策略
                );
            }
            executor.execute(runnable);
        }
    }
}
