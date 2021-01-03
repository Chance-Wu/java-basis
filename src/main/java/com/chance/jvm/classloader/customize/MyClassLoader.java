package com.chance.jvm.classloader.customize;

import sun.applet.AppletClassLoader;
import sun.misc.Launcher;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;

/**
 * <p>
 * 自定义类加载器，重写findClass()方法
 * <p>
 *
 * @author chance
 * @since 2020-07-03
 */
public class MyClassLoader extends ClassLoader {

    /**
     * 编写读取字节流的方法
     *
     * @param fileName 文件名
     * @return
     */
    private byte[] getBytes(String fileName) throws IOException {
        File file = new File(fileName);
        long len = file.length();
        byte[] raw = new byte[(int) len];
        try (FileInputStream fin = new FileInputStream(file)) {
            //一次性读取Class文件的全部二进制数据
            int read = fin.read(raw);
            if (read != len) {
                throw new IOException("无法读取全部文件");
            }
            return raw;
        }
    }

    /**
     * 编写获取类的字节码并创建class对象的逻辑
     *
     * @param name
     * @return
     * @throws ClassNotFoundException
     */
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        Class clazz = null;
        //将包路径的(.)替换为斜线(/)
        String fileStub = name.replace(".", "/");
        String classFileName = fileStub + ".class";
        File classFile = new File(classFileName);

        //如果Class文件存在，系统负责将该文件转换为Class对象
        if (classFile.exists()) {
            try {
                //将Class文件的二进制数据读入数组
                byte[] raw = getBytes(classFileName);
                //调用ClassLoader的defineClass方法将二进制数据转换为Class对象
                clazz = defineClass(name, raw, 0, raw.length);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //如果clazz为null,表明加载失败，抛出异常
        if (null == clazz) {
            throw new ClassNotFoundException(name);
        }
        return clazz;
    }

    public static void main(String[] args) throws Exception {
        String classPath = "com.chance.jvm.classloader.customize.Hello";
        MyClassLoader myClassloader = new MyClassLoader();
        Class<?> aClass = myClassloader.loadClass(classPath);
        Method main = aClass.getMethod("test", String.class);
        System.out.println(main);
        main.invoke(aClass.newInstance(), "Hello World");

        System.out.println("自定义类加载器的父加载器: " + myClassloader.getParent());
        System.out.println("系统默认的AppClassLoader: " + ClassLoader.getSystemClassLoader());
        System.out.println("AppClassLoader的父类加载器: " + ClassLoader.getSystemClassLoader().getParent());
        System.out.println("ExtClassLoader的父类加载器: " + ClassLoader.getSystemClassLoader().getParent().getParent());

    }
}
