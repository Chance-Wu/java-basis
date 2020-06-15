package com.chance.basis.reflection;

/**
 * <p>
 * 反射+动态代理
 * <p>
 *
 * @author chance
 * @since 2020-02-19
 */
public class Test {

    public static void main(String[] args) throws ClassNotFoundException {
        System.out.println(XYZ.name);
    }
}

class XYZ {
    public static String name = "wcy";

    static {
        System.out.println("xyz静态块");
    }

    public XYZ() {
        System.out.println("xyz构造了");
    }
}
