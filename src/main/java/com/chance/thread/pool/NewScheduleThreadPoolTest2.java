package com.chance.thread.pool;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * <p>
 * newScheduleThreadPool
 *
 * 延迟1秒后每3秒执行一次
 * <p>
 *
 * @author chance
 * @since 2020-07-13
 */
public class NewScheduleThreadPoolTest2 {

    public static void main(String[] args) {
        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(5);
        scheduledThreadPool.scheduleAtFixedRate(
            () ->
                    System.out.println("delay 1 seconds, and execute every 3 seconds")
            , 1, 3, TimeUnit.SECONDS);
    }
}
