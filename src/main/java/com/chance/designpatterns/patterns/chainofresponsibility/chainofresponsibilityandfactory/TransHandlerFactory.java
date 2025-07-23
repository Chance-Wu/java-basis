package com.chance.designpatterns.patterns.chainofresponsibility.chainofresponsibilityandfactory;

import com.chance.designpatterns.patterns.chainofresponsibility.chainofresponsibilityandfactory.handler.AuthHandler;
import com.chance.designpatterns.patterns.chainofresponsibility.chainofresponsibilityandfactory.handler.BusinessLogicHandler;
import com.chance.designpatterns.patterns.chainofresponsibility.chainofresponsibilityandfactory.handler.LoggingHandler;
import com.chance.designpatterns.patterns.chainofresponsibility.chainofresponsibilityandfactory.handler.TransHandler;

import java.util.ArrayList;
import java.util.List;

/**
 * 工厂
 *
 * @author chance
 * @date 2024/6/12 15:07
 * @since 1.0
 */
public class TransHandlerFactory {

    public static List<TransHandler> createHandlers(List<TransHandler> transHandlers) {
        List<TransHandler> handlers = new ArrayList<>();
        for (TransHandler transHandler : transHandlers) {
            if (transHandler instanceof AuthHandler) {
                handlers.add(new AuthHandler());
            } else if (transHandler instanceof LoggingHandler) {
                handlers.add(new LoggingHandler());
            } else if (transHandler instanceof BusinessLogicHandler) {
                handlers.add(new BusinessLogicHandler());
            } else {
                throw new IllegalArgumentException("Unknown handler type: " + transHandler);
            }
        }
        return handlers;
    }

}
