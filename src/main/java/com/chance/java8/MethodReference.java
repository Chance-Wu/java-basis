package com.chance.java8;

import java.io.File;
import java.io.FileFilter;

/**
 * <p>
 * 方法引用
 * <p>
 *
 * @author chance
 * @since 2020-02-07
 */
public class MethodReference {

    public static void main(String[] args) {
        //返回一个抽象路径名数组，表示由此抽象路径名表示的满足指定过滤器的目录中的文件和目录
        File[] hiddenFiles = new File(".").listFiles(file -> file.isHidden());

        //Java 8的实现方法
        File[] files = new File(".").listFiles(File::isHidden);
    }
}
