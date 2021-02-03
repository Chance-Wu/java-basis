package com.chance.designpatterns.patterns.proxy;

/**
 * @Description: 代理类
 * @Author: chance
 * @Date: 2020-09-23 09:42
 * @Version 1.0
 */
public class ProxyImage implements Image {

    private RealImage realImage;
    private String fileName;

    public ProxyImage(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void display() {
        if (realImage == null) {
            realImage = new RealImage(fileName);
        }
        realImage.display();
    }

    @Override
    public void ignore() {
        System.out.println("Ignore " + fileName);
    }
}
