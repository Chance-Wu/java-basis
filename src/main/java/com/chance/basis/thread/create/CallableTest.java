package com.chance.basis.thread.create;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.ThreadLocalRandom;

/**
 * <p>
 * 创建Runnable并重写run()方法或者Callable对象并重写call()方法
 * <p>
 *
 * @author chance
 * @since 2020-01-20
 */
public class CallableTest implements Callable<String> {

    /**
     * 任务
     */
    @Override
    public String call() {
        for (int i = 0; i < 100; i++) {
            System.out.println("循环变量i的值" + i);
        }
        return "结束";
    }

    public static void main(String[] args) {
        CallableTest callableTest = new CallableTest();
        FutureTask<String> futureTask = new FutureTask<>(callableTest);
        new Thread(futureTask).start();
        try {
            System.out.println("线程的返回值：" + futureTask.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
