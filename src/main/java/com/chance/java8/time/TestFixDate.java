package com.chance.java8.time;

import java.time.Month;
import java.time.YearMonth;

/**
 * <p>
 * YearMonth类
 * 体现固定日期
 * <p>
 *
 * @author chance
 * @since 2020-05-27
 */
public class TestFixDate {

    public static void main(String[] args) {
        YearMonth currentYearMonth = YearMonth.now();
        System.out.printf("Days in month year %s: %d%n", currentYearMonth, currentYearMonth.lengthOfMonth());

        YearMonth creditCardExpiry = YearMonth.of(2028, Month.FEBRUARY);
        System.out.printf("Your credit card expires on %s %n", creditCardExpiry);
    }
}
