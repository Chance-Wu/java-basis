package com.chance.designpatterns.patterns.chainofresponsibility;

/**
 * 定义了处理请求的方法，以及设置下一个处理者的接口。
 *
 * @author chance
 * @date 2024/6/12 10:20
 * @since 1.0
 */
public interface TransHandler {
    void setNext(TransHandler next);

    void handleRequest(String request);
}
