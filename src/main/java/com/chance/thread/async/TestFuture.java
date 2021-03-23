package com.chance.thread.async;

import java.util.concurrent.*;

/**
 * @Description: TestFuture
 * @Author: chance
 * @Date: 3/16/21 1:38 PM
 * @Version 1.0
 */
public class TestFuture {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(3);
        Future<String> future = executor.submit(new Callable<String>() {

            @Override
            public String call() throws Exception {
                //do some thing
                Thread.sleep(100);
                return "i am ok";
            }
        });
        System.out.println(future.isDone());
        System.out.println(future.get());
    }
}
