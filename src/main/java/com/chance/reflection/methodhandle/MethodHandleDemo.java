package com.chance.reflection.methodhandle;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

/**
 * @author chance
 * @date 2025/6/4 14:00
 * @since 1.0
 */
public class MethodHandleDemo {

    public static void main(String[] args) throws Throwable {
        // 获取 Lookup 对象，用于创建方法句柄
        MethodHandles.Lookup lookup = MethodHandles.lookup();
        // 定义方法类型，这里指定返回类型为 int，参数类型也为 int
        MethodType type = MethodType.methodType(int.class, int.class, int.class);
        // 查找方法句柄，指定要调用的类、方法名和方法类型
        MethodHandle mh = lookup.findVirtual(Calculator.class, "add", type);

        // 创建 Calculator 实例
        Calculator calc = new Calculator();
        // 使用方法句柄调用 Calculator 实例的 add 方法，并传入参数 5 和 3
        int result = (int) mh.invokeExact(calc, 5, 3);

        System.out.println("5 + 3 = " + result);
    }
}
