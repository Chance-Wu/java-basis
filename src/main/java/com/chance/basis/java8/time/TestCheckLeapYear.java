package com.chance.basis.java8.time;

import java.time.LocalDate;

/**
 * <p>
 * 检查闰年
 * <p>
 *
 * @author chance
 * @since 2020-05-27
 */
public class TestCheckLeapYear {

    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        if (today.isLeapYear()) {
            System.out.println("This year is Leap year");
        } else {
            System.out.println("2018 is not a Leap year");
        }
    }
}
