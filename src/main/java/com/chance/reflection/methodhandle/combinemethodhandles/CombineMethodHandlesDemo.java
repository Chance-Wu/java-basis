package com.chance.reflection.methodhandle.combinemethodhandles;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.util.ArrayList;

/**
 * 方法链式调用
 *
 * @author chance
 * @date 2025/6/4 16:14
 * @since 1.0
 */
public class CombineMethodHandlesDemo {

    public static void main(String[] args) throws Throwable {
        // 使用 publicLookup 避免不必要的访问权限问题
        MethodHandles.Lookup lookup = MethodHandles.publicLookup();

        // 获取 Object.toString() 方法句柄
        MethodHandle toString = lookup.findVirtual(Object.class, "toString", MethodType.methodType(String.class));

        // 获取 String.length() 方法句柄
        MethodHandle length = lookup.findVirtual(String.class, "length", MethodType.methodType(int.class));

        // 组合两个方法句柄：先调用 toString，再调用 length
        MethodHandle combo = MethodHandles.filterReturnValue(toString, length);

        // 调用组合句柄，获取结果并打印
        int len = (int) combo.invoke(new ArrayList<>());
        System.out.println(len);
    }
}
