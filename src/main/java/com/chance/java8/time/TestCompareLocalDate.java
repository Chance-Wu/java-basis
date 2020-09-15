package com.chance.java8.time;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * <p>
 * 判断日期是早于还是晚于另一个日期
 * <p>
 *
 * @author chance
 * @since 2020-05-27
 */
public class TestCompareLocalDate {

    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        LocalDate tomorrow = LocalDate.of(2020, 05, 28);
        if (tomorrow.isAfter(today)) {
            System.out.println("Tomorrow comes after today");
        }

        LocalDate yesterday = today.minus(1, ChronoUnit.DAYS);
        if (yesterday.isBefore(today)) {
            System.out.println("Yesterday is day before today");
        }
    }
}
