package com.chance.basis.juc;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * <p>
 * 使用BlockingQueue实现生产者消费者问题
 * <p>
 *
 * @author chance
 * @since 2020-07-21
 */
public class ProductorConsumer {

    private static BlockingQueue<String> queue = new ArrayBlockingQueue<>(5);

    private static class Productor extends Thread {
        @Override
        public void run() {
            try {
                queue.put("product");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("productor...");
        }
    }

    private static class Consumer extends Thread {
        @Override
        public void run() {
            try {
                String product = queue.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("consumer...");
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 2; i++) {
            Productor productor = new Productor();
            productor.start();
        }

        for (int i = 0; i < 5; i++) {
            Consumer consumer = new Consumer();
            consumer.start();
        }

        for (int i = 0; i < 3; i++) {
            Productor productor = new Productor();
            productor.start();
        }
    }
}
