package com.chance.toolkit.utils;

import com.google.common.collect.Maps;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Description: Test
 * @Author: chance
 * @Date: 2021/11/7 12:46 上午
 * @Version 1.0
 */
public class Test {

    public static void main(String[] args) {
//        long coupon_amt = BigDecimal.valueOf(9223372036854.775807).multiply(BigDecimal.valueOf(1000000)).longValue();
//        System.out.println(coupon_amt);
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(10);
    }

    //
    static class Sy{
        long coupon_amt;

        public long getCoupon_amt() {
            return coupon_amt;
        }

        public void setCoupon_amt(long coupon_amt) {
            this.coupon_amt = coupon_amt;
        }
    }
}
