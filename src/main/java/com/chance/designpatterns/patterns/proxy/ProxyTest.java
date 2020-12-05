package com.chance.designpatterns.patterns.proxy;

import org.junit.Test;

/**
 * @Description: ProxyTest
 * @Author: chance
 * @Date: 2020-09-23 09:47
 * @Version 1.0
 */
public class ProxyTest {

    @Test
    public void test() {
        Image image = new ProxyImage("test.jpg");
        // 图像将从磁盘加载
        image.display();
        System.out.println("==========");
        // 图像不需要从磁盘加载
        image.display();
    }
}
