package com.chance.basis.jvm.classloader.clinit.interfaces;

/**
 * <p>
 *
 * <p>
 *
 * @author chance
 * @since 2020-07-02
 */
public class InterfaceInitTestImpl implements InterfaceInitTest1 {

    public static void main(String[] args) {
        System.out.println(InterfaceInitTestImpl.B);
        System.out.println("---------------------------");
        System.out.println("当前时间：" + InterfaceInitTestImpl.A);
    }
}
