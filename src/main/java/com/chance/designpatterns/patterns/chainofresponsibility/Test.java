package com.chance.designpatterns.patterns.chainofresponsibility;

/**
 * @author: chance
 * @date: 2024/6/12 13:35
 * @since: 1.0
 */
public class Test {

    public static void main(String[] args) {
        // 创建处理者实例，并建立责任链
        ConcreteHandler1 handler1 = new ConcreteHandler1();
        ConcreteHandler2 handler2 = new ConcreteHandler2();
        handler1.setNext(handler2);

        // 提交请求
        handler1.handleRequest("two");
    }
}
