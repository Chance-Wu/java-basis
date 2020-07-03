package com.chance.basis.jvm.classloader;

import sun.misc.Launcher;

import java.net.URL;
import java.util.Arrays;

/**
 * <p>
 *
 * <p>
 *
 * @author chance
 * @since 2020-07-02
 */
public class BootstrapTest {
    public static void main(String[] args) {
        // 获取根类加载器所加载的全部URL数组
        URL[] urLs = Launcher.getBootstrapClassPath().getURLs();
        Arrays.stream(urLs).forEach(System.out::println);
    }
}
