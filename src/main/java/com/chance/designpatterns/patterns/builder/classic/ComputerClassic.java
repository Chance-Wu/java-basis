package com.chance.designpatterns.patterns.builder.classic;

/**
 * 目标类
 * @author: chance
 * @date: 2022/9/1 20:07
 * @since: 1.0
 */
public class ComputerClassic {

    private String cpu;
    private String ram;

    private int usbCount;
    private String keyboard;
    private String display;

    public ComputerClassic(String cpu, String ram) {
        this.cpu = cpu;
        this.ram = ram;
    }

    public void setUsbCount(int usbCount) {
        this.usbCount = usbCount;
    }

    public void setKeyboard(String keyboard) {
        this.keyboard = keyboard;
    }

    public void setDisplay(String display) {
        this.display = display;
    }

    @Override
    public String toString() {
        return "Computer2{" +
                "cpu='" + cpu + '\'' +
                ", ram='" + ram + '\'' +
                ", usbCount=" + usbCount +
                ", keyboard='" + keyboard + '\'' +
                ", display='" + display + '\'' +
                '}';
    }
}
