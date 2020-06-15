package com.chance.basis.jvm;

/**
 * <p>
 * String常量池
 * <p>
 *
 * @author chance
 * @since 2020-02-27
 */
public class TestStringPool {

    public static void main(String[] args) {
        createString();
        intern();
        stringSplice();
        testCreateStrObject();
    }

    public static void createString() {
        //先检查字符串常量池中有没有"abcd",如果字符串常量池中没有，则创建一个，
        //然后str1指向字符串常量池中的对象，如果有，则直接将 str1 指向"abcd"
        String str1 = "abcd";
        //堆中创建一个新的对象
        String str2 = new String("abcd");
        //堆中创建一个新的对象
        String str3 = new String("abcd");
        System.out.println(str1 == str2);
        System.out.println(str2 == str3);
    }

    public static void intern() {
        String s1 = new String("计算机");
        //返回字符串对象的规范表示
        String s2 = s1.intern();
        String s3 = "计算机";
        //false，因为一个是堆内存中的 String 对象一个是常量池中的 String 对象，
        System.out.println(s1 == s2);
        //true，因为两个都是常量池中的 String 对象
        System.out.println(s3 == s2);
    }

    public static void stringSplice() {
        String str1 = "str";
        String str2 = "ing";

        //常量池中的对象
        String str3 = "str" + "ing";
        //在堆上创建的新的对象
        String str4 = str1 + str2;
        //常量池中的对象
        String str5 = "string";
        System.out.println(str3 == str4);
        System.out.println(str3 == str5);
        System.out.println(str4 == str5);
    }

    public static void testCreateStrObject() {
        //堆内存的地址值
        String s1 = new String("abc");
        String s2 = "abc";
        //输出 false,因为一个是堆内存，一个是常量池的内存，故两者是不同的。
        System.out.println(s1 == s2);
        //true
        System.out.println(s1.equals(s2));
    }
}
