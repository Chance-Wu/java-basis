package com.chance.jvm.classloader;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;

/**
 * <p>
 * 类加载器的父子关系
 * <p>
 *
 * @author chance
 * @since 2020-07-03
 */
public class ClassLoaderPropTest {

    public static void main(String[] args) throws IOException {

        System.out.println("BootstrapClassLoader 加载的jar包路径" + System.getProperty("sun.boot.class.path"));
        System.out.println("ExtClassLoader 加载的jar包路径" + System.getProperty("java.ext.dirs"));
        System.out.println("AppClassLoader 加载的jar包路径" + System.getProperty("java.class.path"));

        //获取系统类加载器
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        System.out.println("系统类加载器：" + systemClassLoader);

        /*
        获取系统类加载器的加载路径——通常由CLASSPATH环境变量指定，如果操作系统没有指定
        CLASSPATH环境变量，则默认以当前路径作为系统类加载器的加载路径
         */
        Enumeration<URL> eml = systemClassLoader.getResources("");
        while (eml.hasMoreElements()) {
            System.out.println(eml.nextElement());
        }
        //获取系统类加载器的父类加载器，得到扩展类加载器
        ClassLoader extensionLoader = systemClassLoader.getParent();
        System.out.println("系统类的父加载器是扩展类加载器：" + extensionLoader);
        System.out.println("扩展类加载器的加载路径：" + System.getProperty("java.ext.dirs"));
        System.out.println("扩展类加载器的parant：" + extensionLoader.getParent());
    }
}
