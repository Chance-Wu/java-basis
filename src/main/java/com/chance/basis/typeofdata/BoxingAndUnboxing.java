package com.chance.basis.typeofdata;

/**
 * <p>
 * 装箱和拆箱
 * <p>
 *
 * @author chance
 * @since 2020-02-18
 */
public class BoxingAndUnboxing {

    public static void main(String[] args) {
        //对象是在堆内存中,而j(引用变量)是在栈内存中
        Integer i = 10;
        //直接在栈中分配空间
        int n = i;

    }
}
