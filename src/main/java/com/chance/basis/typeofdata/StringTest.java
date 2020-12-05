package com.chance.basis.typeofdata;

/**
 * <p>
 *
 * <p>
 *
 * @author chance
 * @since 2020-07-17
 */
public class StringTest {

    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = "abc";

        /**
         * ==   是比较运算符
         * 如果是基本数据类型，比较的是值是否相等；
         * 如果是引用数据类型，比较的是两个对象的内存地址是否相等。
         */

        // 上方把"abc"同时赋值给s1和s2两个字符串对象，指向的是同一个地址
        System.out.println(s1 == s2);

        // String重写了equals方法
        // 当且仅当该参数不为null，并且是与此对象表示相同字符序列的 String 对象时，结果才为 true
        System.out.println(s1.equals(s2));

        // 在内存中创建了两个对象，一个在堆内存，一个在常量池
        // 堆内存对象是常量池对象的一个拷贝副本
        String abc = new String("abc");
        System.out.println(s1 == abc);

        // Java中有常量优化机制
        String s3 = "a" + "b" + "c";
        String s4 = "abc";
        System.out.println(s3 == s4);
        System.out.println(s3.equals(s4));

        String st1 = "ab";
        String st2 = "abc";
        String st3 = st1 + "c";
        System.out.println(st2 == st3);
        System.out.println(st2.equals(st3));
    }
}
