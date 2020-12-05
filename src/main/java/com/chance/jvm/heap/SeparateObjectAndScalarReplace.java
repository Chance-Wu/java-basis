package com.chance.jvm.heap;

/**
 * @Description: 代码优化之标量替换
 * @Author: chance
 * @Date: 2020-11-04 16:19
 * @Version 1.0
 */
public class SeparateObjectAndScalarReplace {
    public static class User {
        private int age;
        private String name;
    }

    private static void alloc() {
        //未发生逃逸
        User user = new User();
        user.age = 20;
        user.name = "张三";
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        for (int i = 0; i < 100000000; i++) {
            alloc();
        }
        long end = System.currentTimeMillis();
        System.out.println("花费时间：" + (end - start) + "ms");
    }

}
