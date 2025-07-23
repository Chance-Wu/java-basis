package com.chance.reflection.methodhandle.use;

import java.lang.invoke.LambdaMetafactory;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

/**
 * @author chance
 * @date 2025/6/4 15:31
 * @since 1.0
 */
public class StringProcessorDemo {

    public static void main(String[] args) throws Throwable {
        // 获取当前类的MethodHandles.Lookup对象，用于后续操作
        MethodHandles.Lookup lookup = MethodHandles.lookup();

        // 查找String类中的toUpperCase方法的MethodHandle，这将用于动态调用该方法
        MethodHandle toUpperHandle = lookup.findVirtual(String.class, "toUpperCase", MethodType.methodType(String.class));

        // 使用LambdaMetafactory动态创建一个StringProcessor实例
        // 这里演示了如何将一个MethodHandle（toUpperCase方法的）转换为一个符合StringProcessor接口的实现
        StringProcessor processor = (StringProcessor) LambdaMetafactory.metafactory(
                lookup,
                "process",
                MethodType.methodType(StringProcessor.class),
                MethodType.methodType(String.class, String.class),
                toUpperHandle,
                MethodType.methodType(String.class, String.class)
        ).getTarget().invokeExact();

        // 使用动态创建的StringProcessor实例来处理字符串"hello"
        // 预期输出是将字符串转换为大写形式
        String hello = processor.process("hello");
        System.out.println(hello);
    }
}
