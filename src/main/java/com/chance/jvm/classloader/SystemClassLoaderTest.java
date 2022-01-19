package com.chance.jvm.classloader;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;

/**
 * <p>
 *
 * <p>
 *
 * @author chance
 * @since 2020-07-03
 */
public class SystemClassLoaderTest {

    public static void main(String[] args) throws Exception {
        System.out.println(ClassLoader.getSystemClassLoader());
        // 获取线程上下文类加载器
        System.out.println(Thread.currentThread().getContextClassLoader());

        // Array.class的完整路径
        String name = "java/sql/Array.class";
        Enumeration<URL> urls = Thread.currentThread().getContextClassLoader().getResources(name);
        while (urls.hasMoreElements()) {
            URL url = urls.nextElement();
            System.out.println(url.toString());
        }
    }
}
