package com.chance.basis.thread.create;

import com.chance.basis.thread.create.CallableTest;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

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
        //
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 10, 100, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<Runnable>(5));
        Future<String> future = threadPoolExecutor.submit(new CallableTest());

        //
        try {
            System.out.println(future.get());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            threadPoolExecutor.shutdown();
        }
    }
}
