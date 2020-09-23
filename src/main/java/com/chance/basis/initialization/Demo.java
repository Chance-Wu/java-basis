package com.chance.basis.initialization;

/**
 * @Description: Demo
 * @Author: chance
 * @Date: 2020-09-22 15:22
 * @Version 1.0
 */
public class Demo {

    /**
     * 成员变量
     */
    private static final Integer id;
    private String name;

    /**
     * 静态代码块
     */
    static {
        System.out.println("开始初始化对象");
        id = 1;
//        name = "chance";不可以对非静态的成员变量初始化
    }

    public Integer getId() {
        return id;
    }
}
