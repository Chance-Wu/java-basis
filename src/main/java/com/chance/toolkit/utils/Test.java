package com.chance.toolkit.utils;

/**
 * @Description: Test
 * @Author: chance
 * @Date: 2021/11/7 12:46 上午
 * @Version 1.0
 */
public class Test {

    public static void main(String[] args) throws Exception {
//        long coupon_amt = BigDecimal.valueOf(9223372036854.775807).multiply(BigDecimal.valueOf(1000000)).longValue();
//        System.out.println(coupon_amt);
    }

    //
    static class Sy {
        long coupon_amt;

        public long getCoupon_amt() {
            return coupon_amt;
        }

        public void setCoupon_amt(long coupon_amt) {
            this.coupon_amt = coupon_amt;
        }
    }
}
