package com.chance.designpatterns.patterns.proxy.dynamic;

/**
 * @Description: RealImage
 * @Author: chance
 * @Date: 2020-09-23 09:40
 * @Version 1.0
 */
public class RealImage {

    private String fileName;

    public RealImage() {
    }

    public RealImage(String fileName) {
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
