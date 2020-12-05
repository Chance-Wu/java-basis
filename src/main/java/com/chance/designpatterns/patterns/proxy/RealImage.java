package com.chance.designpatterns.patterns.proxy;

/**
 * @Description: RealImage
 * @Author: chance
 * @Date: 2020-09-23 09:40
 * @Version 1.0
 */
public class RealImage implements Image {

    private String fileName;

    public RealImage(String fileName) {
        this.fileName = fileName;
        loadFromDisk(fileName);
    }

    private void loadFromDisk(String fileName) {
        System.out.println("Loading " + fileName);
    }

    @Override
    public void display() {
        System.out.println("Displaying " + fileName);
    }
}
