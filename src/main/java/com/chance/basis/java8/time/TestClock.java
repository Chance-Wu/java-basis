package com.chance.basis.java8.time;

import java.time.Clock;

/**
 * <p>
 * Clock时钟类
 * <p>
 *
 * @author chance
 * @since 2020-05-27
 */
public class TestClock {

    public static void main(String[] args) {
        // 根据系统时间返回当前时间并设置为UTC
        Clock clock = Clock.systemUTC();
        System.out.println("Clock : " + clock);

        // 根据系统时钟区域返回时间
        Clock defaultClock = Clock.systemDefaultZone();
        System.out.println("DefaultClock : " + defaultClock);
    }
}
