package com.chance.designpatterns.patterns.chainofresponsibility.chainofresponsibilityandfactory.handler;

import com.chance.designpatterns.patterns.chainofresponsibility.chainofresponsibilityandfactory.request.TransRequest;

/**
 * 认证处理
 * @author chance
 * @date 2024/6/12 15:37
 * @since 1.0
 */
public class AuthHandler extends TransHandler {
    @Override
    protected boolean doHandle(TransRequest request) {
        System.out.println("AuthHandler: Checking authentication");
        return true;
    }
}
