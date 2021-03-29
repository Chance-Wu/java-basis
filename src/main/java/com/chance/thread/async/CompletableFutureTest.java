package com.chance.thread.async;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @Description: CompletableFutureTest
 * @Author: chance
 * @Date: 3/26/21 10:46 AM
 * @Version 1.0
 */
public class CompletableFutureTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<String> cf1 = new CompletableFuture<>();

        new Thread(() -> {
            // 模拟执行耗时任务
            System.out.println("task doing ...");
            try {
                Thread.sleep(3000);
            } catch (Exception e) {
                cf1.completeExceptionally(e);
            }

            // 告诉completeFuture任务已经完成
            cf1.complete("3");
        }).start();

        CompletableFuture<String> cf2 = new CompletableFuture<>();
        new Thread(() -> {
            // 模拟执行耗时任务
            System.out.println("task doing...");
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                cf2.completeExceptionally(e);
            }
            // 告诉completableFuture任务已经完成
            cf2.complete("1");
        }).start();

        System.out.println(cf1.get());
        System.out.println(cf2.get());
    }
}
