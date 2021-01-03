package com.chance.jvm.classloader.customize;


import java.io.File;
import java.net.*;

/**
 * @Description: FileUrlClassLoader
 * @Author: chance
 * @Date: 1/3/21 11:48 AM
 * @Version 1.0
 */
public class FileUrlClassLoader extends URLClassLoader {

    public FileUrlClassLoader(URL[] urls, ClassLoader parent) {
        super(urls, parent);
    }

    public FileUrlClassLoader(URL[] urls) {
        super(urls);
    }

    public FileUrlClassLoader(URL[] urls, ClassLoader parent, URLStreamHandlerFactory factory) {
        super(urls, parent, factory);
    }

    public static void main(String[] args) throws MalformedURLException {
        String rootDir = "/Users/chance/IdeaProjects/java-basis/src/main/java/";
        //创建自定义文件类加载器
        File file = new File(rootDir);
        //File to URI
        URI uri = file.toURI();
        URL[] urls = {uri.toURL()};

        FileUrlClassLoader loader = new FileUrlClassLoader(urls);

        try {
            //加载指定的class文件
            Class<?> object1 = loader.loadClass("com.chance.jvm.classloader.customize.Hello");
            System.out.println(object1.newInstance().toString());

            //输出结果:I am DemoObj
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
