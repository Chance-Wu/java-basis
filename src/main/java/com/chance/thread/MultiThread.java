package com.chance.thread;

import org.junit.Test;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 * @author chance
 * @version 1.0
 * @date 2022/3/31 15:21
 */
public class MultiThread {

    public static void main(String[] args) {
        // 获取 Java 线程管理 MXBean
        ThreadMXBean threadMxBean = ManagementFactory.getThreadMXBean();
        // 不需要获取同步的 monitor 和 synchronizer 信息，仅获取线程和线程堆栈信息
        ThreadInfo[] threadInfos = threadMxBean.dumpAllThreads(false, false);
        // 遍历线程信息，仅打印线程 ID 和线程名称信息
        for (ThreadInfo threadInfo : threadInfos) {
            System.out.println("[" + threadInfo.getThreadId() + "] " + threadInfo.getThreadName());
        }
    }

    @Test
    public void thread() {
        Thread t = Thread.currentThread();
        System.out.println("Main Thread  Priority:" + t.getPriority());

        Thread t1 = new Thread();
        System.out.println("Thread(t1) Priority:" + t1.getPriority());
        t1.setPriority(Thread.MAX_PRIORITY - 1);
        System.out.println("Thread(t1) Priority:" + t1.getPriority());

        t.setPriority(Thread.NORM_PRIORITY);
        System.out.println("Main Thread  Priority:" + t.getPriority());

        Thread t2 = new Thread();
        System.out.println("Thread(t2) Priority:" + t2.getPriority());

        // Change thread t2 priority to minimum
        t2.setPriority(Thread.MIN_PRIORITY);
        System.out.println("Thread(t2) Priority:" + t2.getPriority());
    }

    @Test
    public void multiThreadDebug() {
        MyThread myThread = new MyThread();
        Thread thread1 = new Thread(myThread, "thread1");
        Thread thread2 = new Thread(myThread, "thread2");
        Thread thread3 = new Thread(myThread, "thread3");
        thread1.start();
        thread2.start();
        thread3.start();
    }

    class MyThread implements Runnable {
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + " running");
        }
    }

    @Test
    public void daemon() {
        Thread childThread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    System.out.println("I'm child thread..");
                    try {
                        TimeUnit.MILLISECONDS.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        childThread.setDaemon(true);
        childThread.start();
        System.out.println("I'm main thread...");
    }

}
