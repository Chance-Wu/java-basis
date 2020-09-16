package com.chance.java8.defaultimpl;

import org.junit.Test;

/**
 * <p>
 *
 * <p>
 *
 * @author chance
 * @since 2020-09-16
 */
public class DefaultImplementsTest {

    @Test
    public void testImplements_01() {
        IFormula formula = new IFormula() {
            @Override
            public double calculate(int a) {
                return a * a;
            }
        };

//        IFormula formula = a -> a;

        System.out.println(formula.calculate(2));
        System.out.println(formula.sqrt(2));
    }

    @Test
    public void testImplements_02() {
        // a 是一个入参名称
        // -> a * a 箭头指向是具体的实现
        IFormula formula = a -> a;

        System.out.println(formula.calculate(2));
        System.out.println(formula.sqrt(2));
    }

    @Test
    public void testAbstract() {
        AFormula aFormula = new AFormula() {
            @Override
            double calculate(int a) {
                return a * a;
            }
        };

        System.out.println(aFormula.calculate(2));
        // 使用抽象类中提供的默认实现
        System.out.println(aFormula.sqrt(2));
    }
}
