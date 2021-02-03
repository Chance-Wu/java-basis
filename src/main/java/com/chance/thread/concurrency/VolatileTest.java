package com.chance.thread.concurrency;

import com.chance.jvm.matespace.Obj;

/**
 * <p>
 *
 * <p>
 *
 * @author chance
 * @since 2020-07-11
 */
public class VolatileTest {

    public static void main(String[] args) {
        while (true) {
            MyObj myObj = new MyObj();
            new Thread(() -> {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                myObj.update(1, 1, 1);
            }).start();

            new Thread(() -> {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                int totalDays = myObj.totalDays();
                System.out.println(totalDays);
            }).start();

        }
    }
}
