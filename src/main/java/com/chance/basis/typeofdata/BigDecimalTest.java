package com.chance.basis.typeofdata;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Calendar;

/**
 * <p>
 * 浮点型数据处理常见问题
 * BigDecimal定义商品金额
 * <p>
 *
 * @author chance
 * @since 2020-07-01
 */
public class BigDecimalTest {

    public static void main(String[] args) {

        // a.条件判断超预期
        System.out.println(1f == 0.99999999f);//超出精度
        System.out.println(1d == 0.99999999d);
        // b.数据转换超预期
        // c.基本运算超预期
        // d.数据自增超预期


        BigDecimal num1 = new BigDecimal(0.005);
        BigDecimal num2 = new BigDecimal(1000000);
        BigDecimal num3 = new BigDecimal(-1000000);

        // 1.尽量用字符串的形式初始化
        BigDecimal num12 = new BigDecimal("0.005");
        BigDecimal num22 = new BigDecimal("1000000");
        BigDecimal num32 = new BigDecimal("-1000000");

        // 2.加法
        BigDecimal result1 = num1.add(num2);
        BigDecimal result12 = num12.add(num22);

        // 3.减法
        BigDecimal result2 = num1.subtract(num2);
        BigDecimal result22 = num12.subtract(num22);

        // 4.乘法
        BigDecimal result3 = num1.multiply(num2);
        BigDecimal result32 = num12.multiply(num22);

        // 5.绝对值
        BigDecimal result4 = num3.abs();
        BigDecimal result42 = num32.abs();

        // 6.除法
        BigDecimal result5 = num2.divide(num1, 20, BigDecimal.ROUND_HALF_UP);
        BigDecimal result52 = num22.divide(num12, 20, BigDecimal.ROUND_HALF_UP);

        System.out.println("加法用value结果：" + result1);
        System.out.println("加法用string结果：" + result12);

        System.out.println("减法value结果：" + result2);
        System.out.println("减法用string结果：" + result22);

        System.out.println("乘法用value结果：" + result3);
        System.out.println("乘法用string结果：" + result32);

        System.out.println("绝对值用value结果：" + result4);
        System.out.println("绝对值用string结果：" + result42);

        System.out.println("除法用value结果：" + result5);
        System.out.println("除法用string结果：" + result52);


//        BigDecimal a = new BigDecimal(5.123456);
//        BigDecimal b = new BigDecimal(100d);
//        BigDecimal divide = a.divide(b, 6, RoundingMode.HALF_UP);
//        System.out.println(divide);
    }
}
