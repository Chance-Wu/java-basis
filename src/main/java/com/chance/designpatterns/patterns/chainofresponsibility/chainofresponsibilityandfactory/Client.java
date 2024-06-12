package com.chance.designpatterns.patterns.chainofresponsibility.chainofresponsibilityandfactory;

import com.chance.designpatterns.patterns.chainofresponsibility.chainofresponsibilityandfactory.handler.AuthHandler;
import com.chance.designpatterns.patterns.chainofresponsibility.chainofresponsibilityandfactory.handler.BusinessLogicHandler;
import com.chance.designpatterns.patterns.chainofresponsibility.chainofresponsibilityandfactory.handler.LoggingHandler;
import com.chance.designpatterns.patterns.chainofresponsibility.chainofresponsibilityandfactory.handler.TransHandler;
import com.chance.designpatterns.patterns.chainofresponsibility.chainofresponsibilityandfactory.request.AuthRequest;
import com.chance.designpatterns.patterns.chainofresponsibility.chainofresponsibilityandfactory.request.TransRequest;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: chance
 * @date: 2024/6/12 16:21
 * @since: 1.0
 */
public class Client {

    /**
     * 消息发送给的目标,这里选用抽象,提高扩展性
     */
    private List<TransHandler> transHandlers;

    /**
     * 配置客户的处理器
     *
     * @param handlers
     */
    public void setHandlers(List<TransHandler> handlers) {
        this.transHandlers = handlers;
    }

    public static void processRequest(TransRequest request, List<TransHandler> transHandlers) {
        // 使用工厂创建处理器
        List<TransHandler> handlers = TransHandlerFactory.createHandlers(transHandlers);

        // 使用工具类构建责任链
        TransHandler chain = ChainBuilder.buildChain(handlers);

        // 处理请求
        chain.handleRequest(request);
    }

    public static void main(String[] args) {
        List<TransHandler> transHandlerList = new ArrayList<>();
        transHandlerList.add(new AuthHandler());
        transHandlerList.add(new LoggingHandler());
        transHandlerList.add(new BusinessLogicHandler());

        AuthRequest authRequest = new AuthRequest();
        // 使用抽象方法创建和使用责任链
        processRequest(authRequest, transHandlerList);
    }
}
