package com.chance.basis.thread.stopthread;

/**
 * <p>
 * 在sleep状态下停止线程
 * <p>
 *
 * @author chance
 * @since 2020-07-02
 */
public class MyThread3 extends Thread {

    @Override
    public void run() {
        super.run();

        try {
            System.out.println("线程开始。。。");
            Thread.sleep(200000);
            System.out.println("线程结束。");
        } catch (InterruptedException e) {
            System.out.println("在沉睡中被停止, 进入catch， 调用isInterrupted()方法的结果是：" + this.isInterrupted());
            e.printStackTrace();
        }

    }
}
