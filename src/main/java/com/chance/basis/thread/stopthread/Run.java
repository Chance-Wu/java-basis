package com.chance.basis.thread.stopthread;

/**
 * <p>
 * interrupt()方法的使用效果并不像for+break语句那样，马上就停止循环。
 * 调用interrupt方法是在当前线程中打了一个停止标志，并不是真的停止线程。
 * <p>
 *
 * @author chance
 * @since 2020-07-02
 */
public class Run {

    public static void main(String[] args) {
        MyThread thread = new MyThread();
        thread.start();
        try {
            Thread.sleep(2000);
            // 实际上只是给线程设置一个中断标志，线程仍会继续运行
            thread.interrupt();
            System.out.println("Stop 1??" + Thread.interrupted());
            System.out.println("Stop 2??" + Thread.interrupted());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
