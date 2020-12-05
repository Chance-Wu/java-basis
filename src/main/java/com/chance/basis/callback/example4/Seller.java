package com.chance.basis.callback.example4;

/**
 * @Description: Seller
 * @Author: chance
 * @Date: 2020-09-23 14:59
 * @Version 1.0
 */
public class Seller {

    private String name;

    public Seller(String name) {
        this.name = name;
    }

    class DoHomeWork implements DoJob {

        @Override
        public void fillBlank(int a, int b, int result) {
            System.out.println(name + "求助小红算账:" + a + " + " + b + " = " + result + "元");
        }
    }

    public void callHelp(int a, int b) {
        new SuperCalculator().add(a, b, new DoHomeWork());
    }
}
