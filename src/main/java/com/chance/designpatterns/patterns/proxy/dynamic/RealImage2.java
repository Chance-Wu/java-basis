package com.chance.designpatterns.patterns.proxy.dynamic;

/**
 * @Description: RealImage
 * @Author: chance
 * @Date: 2020-09-23 09:40
 * @Version 1.0
 */
public class RealImage2 {

    private String fileName;

    public RealImage2() {
    }

    public RealImage2(String fileName) {
        this.fileName = fileName;
        loadFromDisk(fileName);
    }

    private void loadFromDisk(String fileName) {
        System.out.println("Loading " + fileName);
    }

    public void display() {
        System.out.println("Displaying " + fileName);
    }

    public void ignore() {
        System.out.println("Ignore " + fileName);
    }
}
