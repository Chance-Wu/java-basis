package com.chance.basis.thread.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * <p>
 * newSingleThreadPool
 * <p>
 *
 * @author chance
 * @since 2020-07-13
 */
public class NewSingleThreadPoolTest {

    public static void main(String[] args) {
        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 10; i++) {
            final int index = i;
            singleThreadExecutor.execute(
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
