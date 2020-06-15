package com.chance.basis.java8.time;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * <p>
 * 解析或格式化日期
 * <p>
 *
 * @author chance
 * @since 2020-05-27
 */
public class TestFormatDate {

    public static void main(String[] args) {
        String dayAfterTomorrow = "20200529";
        LocalDate formatted = LocalDate.parse(dayAfterTomorrow, DateTimeFormatter.BASIC_ISO_DATE);
        System.out.printf("Date generated from String %s is %s %n", dayAfterTomorrow, formatted);

        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("YYYY-mm-dd hh:mm:ss");
        String format = dateTimeFormatter.format(now);
        System.out.printf("String generated from Date %s is %s %n", now, format);
    }
}
