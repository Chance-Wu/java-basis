package com.chance.jvm.classloader.test;

/**
 * @Description: InitiativeUse
 * @Author: chance
 * @Date: 12/31/20 3:02 PM
 * @Version 1.0
 */
public class InitiativeUse {

    /**
     * 首先看到 Son.strFather，你会发现是子类 Son 访问父类 Father 的静态变量 strFather ，
     * 这个时候就千万要记住在归纳主动使用概念时特别提到过的一个注意点了：对于静态字段，只有直接定义这个字段的类才会被初始化（执行静态代码块），这句话在继承、多态中最为明显！
     *
     * Son.strFather 中的静态字段是属于父类 Father 的对吧，也就是说直接定义这个字段的类是父类 Father ，所以在执行 System.out.println(Son.strFather); 这句代码的时候会去初始化 Father 类而不是子类 Son ！
     */
    public static void main(String[] args) {
        System.out.println(Son.strFather);
    }
}
