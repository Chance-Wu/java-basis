package com.chance.basis.thread.communicate.poll;

/**
 * <p>
 *
 * <p>
 *
 * @author chance
 * @since 2020-07-01
 */
public class Test {

    public static void main(String[] args) {
        MyList service = new MyList();

        ThreadA a = new ThreadA(service);
        a.setName("A");
        a.start();

        ThreadB b = new ThreadB(service);
        b.setName("B");
        b.start();
    }
}
