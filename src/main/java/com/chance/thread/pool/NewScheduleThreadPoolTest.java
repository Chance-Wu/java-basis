package com.chance.thread.pool;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * <p>
 * newScheduleThreadPool
 * <p>
 *
 * @author chance
 * @since 2020-07-13
 */
public class NewScheduleThreadPoolTest {

    public static void main(String[] args) {
        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(5);
        // 延迟3秒执行
        scheduledThreadPool.schedule(
                () -> System.out.println("delay 3 seconds"), 3, TimeUnit.SECONDS
        );
    }
}
