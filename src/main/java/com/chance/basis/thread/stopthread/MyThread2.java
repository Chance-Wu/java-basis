package com.chance.basis.thread.stopthread;

/**
 * <p>
 *
 * <p>
 *
 * @author chance
 * @since 2020-07-02
 */
public class MyThread2 extends Thread {

    @Override
    public void run() {
        super.run();
        for (int i = 0; i < 500000; i++) {
            // 在线程中用for语句来判断一下线程是否是停止状态，如果是停止状态，则后面的代码不再运行即可
            if (interrupted()) {
                System.out.println("线程已经终止， for循环不再执行");
                break;
            }
            System.out.println("i=" + (i + 1));
        }
    }
}
