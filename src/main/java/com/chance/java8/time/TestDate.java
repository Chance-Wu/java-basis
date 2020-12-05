package com.chance.java8.time;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * <p>
 *
 * <p>
 *
 * @author chance
 * @since 2020-05-23
 */
public class TestDate {

    public static void main(String[] args) throws ParseException {
        //当天开始时间
        LocalDateTime today_start = LocalDateTime.of(LocalDate.now().minusDays(1), LocalTime.MIN);

        //当天结束时间 
        LocalDateTime today_end = LocalDateTime.of(LocalDate.now().minusDays(1), LocalTime.MAX);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String stime = formatter.format(today_start);
        String etime = formatter.format(today_end);
        System.out.println(stime);
        System.out.println(etime);
    }
}
