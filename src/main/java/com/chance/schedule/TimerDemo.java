package com.chance.schedule;

import java.util.Timer;
import java.util.TimerTask;

/**
 * @Description: Timer方式实现任务调度
 * @Author: chance
 * @Date: 7/27/21 2:01 PM
 * @Version 1.0
 */
public class TimerDemo {

    public static void main(String[] args) {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println(">>>>>>>>>do something");
            }
        },1000,2000);
        // 1s后开始调度，每2s执行一次
    }
}
