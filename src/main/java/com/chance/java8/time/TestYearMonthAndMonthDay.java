package com.chance.java8.time;

import java.time.LocalDate;
import java.time.MonthDay;

/**
 * <p>
 * 处理周期性的日期
 * MonthDay、YearMonth
 * <p>
 *
 * @author chance
 * @since 2020-05-26
 */
public class TestYearMonthAndMonthDay {

    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        LocalDate dateOfBirth = LocalDate.of(2020, 9, 19);
        MonthDay birthDay = MonthDay.of(dateOfBirth.getMonth(), dateOfBirth.getDayOfMonth());
        //当前的月份日期
        MonthDay currentMonthDay = MonthDay.from(today);

        if (currentMonthDay.equals(birthDay)) {
            System.out.println("Many Many happy returns of the day !!");
        } else {
            System.out.println("Sorry, today is not your birthday");
        }
    }
}
