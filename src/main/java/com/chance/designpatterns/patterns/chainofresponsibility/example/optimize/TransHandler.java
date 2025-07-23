package com.chance.designpatterns.patterns.chainofresponsibility.example.optimize;

/**
 * 处理传输请求的接口。
 * 实现这个接口的类将形成一个处理链，每个处理器负责特定类型的传输请求。
 * 使用链式处理的优点是可以在不中断处理链的情况下动态添加或移除处理节点。
 *
 * @author chance
 * @date 2024/6/20 13:19
 * @since 1.0
 */
public interface TransHandler {

    /**
     * 设置下一个处理者。
     * 通过这种方式，处理器形成一个链式结构。
     *
     * @param next 接下来负责处理请求的处理器。
     */
    void setNext(TransHandler next);

    /**
     * 处理传输请求。
     * 具体的处理逻辑由实现这个接口的类来定义。
     *
     * @return 处理结果的代码。代码的具体含义由实现类自行定义。
     */
    int handle();
}
