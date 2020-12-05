package com.chance.basis.juc;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * <p>
 * 输出结果
 * other task is running...
 * 4950
 * <p>
 *
 * @author chance
 * @since 2020-07-21
 */
public class FutureTaskExample {

    public static void main(String[] args)
            throws ExecutionException, InterruptedException {

        FutureTask<Integer> futureTask = new FutureTask<>(() -> {
            int result = 0;
            for (int i = 0; i < 100; i++) {
                Thread.sleep(10);
                result += i;
            }
            return result;
        });

        Thread computeThread = new Thread(futureTask);
        computeThread.start();
        Thread otherThread = new Thread(() -> {
            System.out.println("other task is running...");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        });
        otherThread.start();
        System.out.println(futureTask.get());
    }
}
