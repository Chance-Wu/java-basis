package com.chance.designpatterns.patterns.chainofresponsibility.chainofresponsibilityandfactory.handler;

import com.chance.designpatterns.patterns.chainofresponsibility.chainofresponsibilityandfactory.request.TransRequest;

/**
 * 处理抽象类
 *
 * @author: chance
 * @date: 2024/6/12 14:57
 * @since: 1.0
 */
public abstract class TransHandler {

    /**
     * 自身引用：后继
     * -- SETTER --
     * 提供给相应的子类去调用，指定对应的处理器
     *
     * @param nextHandler 后继处理器
     */
    protected TransHandler nextHandler;

    public void setNextHandler(TransHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    /**
     * 处理传输请求
     *
     * @param request 处理的请求参数
     */
    public void handleRequest(TransRequest request) {
        // 处理请求
        if (doHandle(request) && nextHandler != null) {
            // 如果处理成功，则交给后继处理
            nextHandler.handleRequest(request);
        }
    }

    /**
     * 提供抽象方法，对于特定请求需要具体的子类去实现
     *
     * @param request 处理的请求参数
     * @return 处理结果
     */
    protected abstract boolean doHandle(TransRequest request);
}
