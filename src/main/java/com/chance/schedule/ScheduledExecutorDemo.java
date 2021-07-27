package com.chance.schedule;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @Description: ScheduledExecutor方式实现任务调度
 * @Author: chance
 * @Date: 7/27/21 3:38 PM
 * @Version 1.0
 */
public class ScheduledExecutorDemo {

    public static void main(String[] args) {
        ScheduledExecutorService service = Executors.newScheduledThreadPool(10);
        service.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                System.out.println(">>>>>>>>>do something");
            }
        }, 1, 2, TimeUnit.SECONDS);
    }
}
