package com.chance.java8.time;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.temporal.ChronoUnit;

/**
 * <p>
 * ChronoUnit类的用法
 * java.time.Period类计算两个日期之间的天数
 * <p>
 *
 * @author chance
 * @since 2020-05-26
 */
public class TestCalculateTime {

    public static void main(String[] args) {
        // 计算一周后的日期
        LocalDate today = LocalDate.now();
        LocalDate nextWeek = today.plus(1, ChronoUnit.WEEKS);
        System.out.println("Today is : " + today);
        System.out.println("Date after 1 week : " + nextWeek);

        // 计算一年前或一年后的日期
        LocalDate now = LocalDate.now();
        LocalDate previousYear = now.minus(1, ChronoUnit.YEARS);
        System.out.println("Date before 1 year : " + previousYear);

        LocalDate nextYear = now.plus(1, ChronoUnit.YEARS);
        System.out.println("Date after 1 year : " + nextYear);

        // 计算两个日期之间的天数和月数
        LocalDate now1 = LocalDate.now();
        LocalDate java8Release = LocalDate.of(2020, Month.JULY, 14);
        Period periodToNextJavaRelease = Period.between(now1, java8Release);
        System.out.println("Months left between today and Java 8 release : " + periodToNextJavaRelease.getMonths());
    }
}
