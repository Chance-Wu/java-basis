package com.chance.designpatterns.patterns.chainofresponsibility;

/**
 * @author chance
 * @date 2024/6/12 13:35
 * @since 1.0
 */
public class Test {

    public static void main(String[] args) {
//        // 创建处理者实例，并建立责任链
//        ConcreteHandler1 handler1 = new ConcreteHandler1();
//        ConcreteHandler2 handler2 = new ConcreteHandler2();
//        handler1.setNext(handler2);
//
//        // 提交请求
//        handler1.handleRequest("two");

        // 使用ChainBuilder来构建责任链
        ChainBuilder builder = new ChainBuilder();
        TransHandler handler1 = new ConcreteHandler1();
        TransHandler handler2 = new ConcreteHandler2();
        // 实际应用中，这些处理器可能有不同的实现或配置

        // 添加处理器到链中
        TransHandler firstInChain = builder
                .addHandler(handler1)
                .addHandler(handler2)
                .build();

        // 提交请求
        firstInChain.handleRequest("two");
    }
}
