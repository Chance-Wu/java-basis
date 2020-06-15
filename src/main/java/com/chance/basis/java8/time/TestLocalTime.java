package com.chance.basis.java8.time;

import java.time.LocalTime;

/**
 * <p>
 * LocalTime的用法
 * <p>
 *
 * @author chance
 * @since 2020-05-26
 */
public class TestLocalTime {

    public static void main(String[] args) {
        // 获取当前时间
        LocalTime time = LocalTime.now();
        System.out.println("local time now: " + time);

        // 在现有的时间上加两小时
        LocalTime now = LocalTime.now();
        LocalTime newTime = now.plusHours(2);
        System.out.println("Time after 2 hours: " + newTime);
    }
}
