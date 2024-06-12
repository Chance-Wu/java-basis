package com.chance.designpatterns.patterns.chainofresponsibility.chainofresponsibilityandfactory.handler;

import com.chance.designpatterns.patterns.chainofresponsibility.chainofresponsibilityandfactory.request.TransRequest;

/**
 * 业务逻辑处理
 * @author: chance
 * @date: 2024/6/12 15:38
 * @since: 1.0
 */
public class BusinessLogicHandler extends TransHandler {
    @Override
    protected boolean doHandle(TransRequest request) {
        System.out.println("BusinessLogicHandler: Processing business logic");
        return true;
    }
}
