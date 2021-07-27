package com.chance.schedule;

/**
 * @Description: 多线程方式实现任务调度
 * @Author: chance
 * @Date: 7/27/21 1:42 PM
 * @Version 1.0
 */
public class ThreadDemo {

    public static void main(String[] args) {
        // 每隔10s执行任务
        final long timeInterval = 10000;
        Runnable runnable = () -> {
            while (true) {
                try {
                    Thread.sleep(timeInterval);
                    System.out.println(">>>>>>>>do something");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
    }
}
