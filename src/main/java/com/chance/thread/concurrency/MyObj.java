package com.chance.thread.concurrency;

/**
 * @Description: MyObj
 * @Author: chance
 * @Date: 1/22/21 9:38 AM
 * @Version 1.0
 */
public class MyObj {

    private int years;
    private int months;
    private volatile int days;

    public int totalDays() {
        int total = this.days;
        total += months * 30;
        total += years * 365;
        return total;
    }

    public void update(int years, int months, int days) {
        this.years = years;
        this.months = months;
        this.days = days;
    }
}
