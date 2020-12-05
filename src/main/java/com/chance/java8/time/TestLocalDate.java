package com.chance.java8.time;

import java.time.LocalDate;

/**
 * <p>
 * LocalDate的用法
 * <p>
 *
 * @author chance
 * @since 2020-05-22
 */
public class TestLocalDate {

    public static void main(String[] args) {
        // 1.获取当前日期（不包含时间）
        LocalDate now = LocalDate.now();
        System.out.println("Today is " + now);

        // 2.获取年月日
        LocalDate today = LocalDate.now();
        int year = today.getYear();
        int month = today.getMonthValue();
        int day = today.getDayOfMonth();
        System.out.printf("Year : %d  Month : %d  day : %d t %n", year, month, day);

        // 3.处理特定日期
        LocalDate dateOfBirth = LocalDate.of(2018, 01, 21);
        System.out.println("The special date is : " + dateOfBirth);

        // 4.判断两个日期是否相等
        LocalDate today1 = LocalDate.now();
        LocalDate date1 = LocalDate.of(2020, 05, 26);

        if (date1.equals(today1)) {
            System.out.printf("TODAY %s and DATE1 %s are same date %n", today, date1);
        }
    }
}
