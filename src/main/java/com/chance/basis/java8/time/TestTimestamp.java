package com.chance.basis.java8.time;

import java.time.Instant;

/**
 * <p>
 * 获取当前时间戳
 * <p>
 *
 * @author chance
 * @since 2020-05-27
 */
public class TestTimestamp {

    public static void main(String[] args) {
        Instant timestamp = Instant.now();
        System.out.println("What is value of this instant " + timestamp);
    }
}
