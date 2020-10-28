package com.chance.thread.communicate.sync;

/**
 * <p>
 * 线程间通信方式：
 * （1）同步：本质上就是“共享内存”式的通信。多个线程需要访问同一个共享变量，谁拿到了锁（获得了访问权限），谁就可以执行。
 * <p>
 *
 * @author chance
 * @since 2020-06-30
 */
public class TestSynchronized {

    public static void main(String[] args) {
        MyObject object = new MyObject();

        // 由于线程A和线程B持有同一个MyObject类的对象object，
        //尽管两个线程需要调用不同的方法，但是它们是同步执行的，
        //比如：线程B需要等待线程A执行完了methodA()方法之后，它才能执行methodB()方法。这样，线程A和线程B就实现了通信。
        ThreadA threadA = new ThreadA(object);
        ThreadB threadB = new ThreadB(object);
        threadA.start();
        threadB.start();
    }
}
