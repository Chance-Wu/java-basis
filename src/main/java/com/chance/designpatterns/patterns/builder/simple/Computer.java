package com.chance.designpatterns.patterns.builder.simple;

/**
 * @Description: 简化使用Builder的方式
 * @Author: chance
 * @Date: 4/12/21 8:49 PM
 * @Version 1.0
 */
public class Computer {

    /**
     * 必传参数
     */
    private final String cpu;
    private final String ram;

    /**
     * 可选参数
     */
    private final int usbCount;
    private final String keyboard;
    private final String display;

    /**
     * 私有构造函数，参数为Builder类型
     * @param builder
     */
    private Computer(Builder builder) {
        this.cpu = builder.cpu;
        this.ram = builder.ram;
        this.usbCount = builder.usbCount;
        this.keyboard = builder.keyboard;
        this.display = builder.diplay;
    }

    /**
     * 静态内部类，将Couputer中的参数都复制过来
     */
    public static class Builder {
        private String cpu;//必须
        private String ram;//必须
        private int usbCount;//可选
        private String keyboard;//可选
        private String diplay;//可选

        /**
         * 创建一个必填参数的构造函数
         * @param cpu
         * @param ram
         */
        public Builder(String cpu, String ram) {
            this.cpu = cpu;
            this.ram = ram;
        }

        public void setUsbCount(int usbCount) {
            this.usbCount = usbCount;
        }

        public void setKeyboard(String keyboard) {
            this.keyboard = keyboard;
        }

        public void setDiplay(String diplay) {
            this.diplay = diplay;
        }

        /**
         * 创建一个build()方法，在其中构建Computer的实例并返回
         * @return
         */
        public Computer build() {
            return new Computer(this);
        }
    }
}
