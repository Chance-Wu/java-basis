package com.chance.designpatterns.patterns.chainofresponsibility.example.optimize;

/**
 * 抽象处理类，作为责任链模式中的节点。
 * 该类为处理请求的实体提供了一个抽象接口，具体的处理逻辑由其子类实现。
 * 节点之间通过next指针形成链式结构，以便请求在链中传递。
 *
 * @author chance
 * @date 2024/6/20 10:22
 * @since 1.0
 */
public abstract class AbstractHandler implements TransHandler {

    /**
     * 下一个处理者，用于形成责任链。
     */
    protected TransHandler next;

    /**
     * 设置下一个处理者。
     * 通过该方法，可以动态地构建责任链。
     *
     * @param next 下一个处理者
     */
    @Override
    public void setNext(TransHandler next) {
        this.next = next;
    }
}
