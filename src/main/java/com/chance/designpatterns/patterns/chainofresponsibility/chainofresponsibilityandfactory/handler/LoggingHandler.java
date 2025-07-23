package com.chance.designpatterns.patterns.chainofresponsibility.chainofresponsibilityandfactory.handler;

import com.chance.designpatterns.patterns.chainofresponsibility.chainofresponsibilityandfactory.request.TransRequest;

/**
 * 日志处理
 * @author chance
 * @date 2024/6/12 15:37
 * @since 1.0
 */
public class LoggingHandler extends TransHandler {
    @Override
    protected boolean doHandle(TransRequest request) {
        System.out.println("LoggingHandler: Logging request");
        return true;
    }
}
