package com.chance.jvm.classloader;

/**
 * @Description: ClassLoaderLevel
 * @Author: chance
 * @Date: 2021/9/2 2:12 下午
 * @Version 1.0
 */
public class ClassLoaderLevel {

    public static void main(String[] args) {
        System.out.println(String.class.getClassLoader());
        System.out.println(sun.awt.HKSCS.class.getClassLoader());
        System.out.println(sun.net.spi.nameservice.dns.DNSNameService.class.getClassLoader());
        System.out.println(ClassLoaderPropTest.class.getClassLoader());

        System.out.println(sun.net.spi.nameservice.dns.DNSNameService.class.getClassLoader().getClass().getClassLoader());
        System.out.println(ClassLoaderPropTest.class.getClassLoader().getClass().getClassLoader());
    }
}
