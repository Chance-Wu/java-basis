package com.chance.basis.jvm.classloader.clinit.interfaces;

import java.sql.SQLOutput;

/**
 * <p>
 *
 * <p>
 *
 * @author chance
 * @since 2020-07-02
 */
public class CurrentTime {
    static long getTime() {
        System.out.println("加载了InterfaceInitTest接口");
        return System.currentTimeMillis();
    }
}
