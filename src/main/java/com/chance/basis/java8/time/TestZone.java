package com.chance.basis.java8.time;

import java.time.*;

/**
 * <p>
 * ZoneId类、ZoneDateTime类、ZoneOffset类
 *
 * <p>
 *
 * @author chance
 * @since 2020-05-27
 */
public class TestZone {

    public static void main(String[] args) {
        ZoneId america = ZoneId.of("America/New_York");
        LocalDateTime localDateTime = LocalDateTime.now();
        ZonedDateTime dateTimeInNewYork = ZonedDateTime.of(localDateTime, america);
        System.out.println("现在的日期时间在特定的时区 : " + dateTimeInNewYork);

        LocalDateTime dateTime = LocalDateTime.of(2020, Month.FEBRUARY, 14, 19, 30);
        ZoneOffset offset = ZoneOffset.of("+05:30");
        OffsetDateTime date = OffsetDateTime.of(dateTime, offset);
        System.out.println("Date and Time with timezone offset in Java : " + date);
    }
}
