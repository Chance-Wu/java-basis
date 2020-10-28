package com.chance.thread.concurrency;

import java.util.concurrent.Semaphore;

/**
 * @Description: SemaphoreTest
 * @Author: chance
 * @Date: 2020-10-27 15:43
 * @Version 1.0
 */
public class SemaphoreTest {

    public void testSemaphore() {

        // 创建一个计数阈值为 5 的信号量对象
        // 只能 5 个线程同时访问
        Semaphore semaphore = new Semaphore(5);
        try { // 申请许可
            semaphore.acquire();
            try {
                // 业务逻辑
            } catch (Exception e) {

            } finally {
                // 释放许可
                semaphore.release();
            }
        } catch (InterruptedException e) {

        }
    }
}
