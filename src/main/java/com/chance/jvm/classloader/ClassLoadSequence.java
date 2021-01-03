package com.chance.jvm.classloader;

/**
 * @Description: ClassLoaderDemo
 * @Author: chance
 * @Date: 1/1/21 10:44 PM
 * @Version 1.0
 */
public class ClassLoadSequence {

    public static void main(String[] args) {
        ClassLoader cl = ClassLoadSequence.class.getClassLoader();
        System.out.println("类加载器（类$内部类@十六进制哈希码）：" + cl);
        System.out.println("哈希码：" + String.format("%08X", cl.hashCode()));
    }
}
