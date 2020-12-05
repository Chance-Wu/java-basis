package com.chance.java8.stream;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * <p>
 *
 * <p>
 *
 * @author chance
 * @since 2020-09-16
 */
public class ParallelStreamTest {

    @Test
    public void testParallelStreamSort() {
        int max = 1000000;
        List<String> values = new ArrayList<>(max);
        for (int i = 0; i < max; i++) {
            UUID uuid = UUID.randomUUID();
            values.add(uuid.toString());
        }

        long t0 = System.nanoTime();
        long count = values.parallelStream().count();
        System.out.println(count);
        long t1 = System.nanoTime();
        long millis = TimeUnit.NANOSECONDS.toMillis(t1 - t0);
        System.out.println(String.format("顺序流排序耗时: %d ms", millis));
    }

    @Test
    public void testStreamSort() {
        int max = 1000000;
        List<String> values = new ArrayList<>(max);
        for (int i = 0; i < max; i++) {
            UUID uuid = UUID.randomUUID();
            values.add(uuid.toString());
        }

        // 纳秒
        long t0 = System.nanoTime();
        long count = values.stream().count();
        System.out.println(count);
        long t1 = System.nanoTime();
        // 纳秒转微秒
        long millis = TimeUnit.NANOSECONDS.toMillis(t1 - t0);
        System.out.println(String.format("顺序流排序耗时: %d ms", millis));
    }
}
