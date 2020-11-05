package com.chance.jvm.classloader.init;

/**
 * <p>
 *
 * <p>
 *
 * @author chance
 * @since 2020-07-02
 */
public class Tester {

    static {
        System.out.println("Tester类的静态初始化块");
    }
}

class ClassLoaderTest {
    public static void main(String[] args) throws ClassNotFoundException {
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        //下面仅仅是加载Tester类
        classLoader.loadClass("com.chance.jvm.classloader.init.Tester");
        System.out.println("系统加载Tester类");
        //下面才会初始化Tester类
        Class.forName("com.chance.jvm.classloader.init.Tester");
    }
}

