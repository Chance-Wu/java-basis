package com.chance.basis.concurrency;

/**
 * <p>
 * 内存屏障
 * <p>
 * 说明JVM是如何插入内存屏障的
 * <p>
 *
 * @author chance
 * @since 2020-07-13
 */
public class MemoryBarrier {

    int a, b;
    volatile int v, u;

    void f() {
        int i, j;

        i = a;
        j = b;
        i = v;
        //LoadLoad
        j = u;
        //LoadStore
        a = i;
        b = j;
        //StoreStore
        v = i;
        //StoreStore
        u = j;
        //StoreLoad
        i = u;
        //LoadLoad
        //LoadStore
        j = b;
        a = i;
    }
}
