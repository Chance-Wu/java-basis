package com.chance.basis.jvm.classloader.clinit.clazz;

/**
 * <p>
 * 父类的静态初始化块在子类静态变量初始化之前初始化完毕
 * <p>
 *
 * @author chance
 * @since 2020-07-02
 */
public class Testclinit extends Test {

    private static int B = A;

    public static void main(String[] args) {
        // 所以输出结果是20，不是10。
        System.out.println(Testclinit.B);
    }
}
