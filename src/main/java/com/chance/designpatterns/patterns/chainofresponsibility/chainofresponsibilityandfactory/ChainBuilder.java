package com.chance.designpatterns.patterns.chainofresponsibility.chainofresponsibilityandfactory;

import com.chance.designpatterns.patterns.chainofresponsibility.chainofresponsibilityandfactory.handler.TransHandler;

import java.util.Collections;
import java.util.List;

/**
 * 责任链构建器
 *
 * @author: chance
 * @date: 2024/6/12 15:56
 * @since: 1.0
 */
public class ChainBuilder {

    /**
     * 构建责任链
     *
     * @param handlers 处理器列表
     * @return 责任链的第一个处理器
     * @throws IllegalArgumentException 如果处理器列表为null或空
     */
    public static TransHandler buildChain(List<TransHandler> handlers) throws IllegalArgumentException {
        // 检查handlers是否为空或空列表
        if (handlers == null || handlers.isEmpty()) {
            throw new IllegalArgumentException("TransHandler list cannot be null or empty");
        }

        // 防止在并发情况下修改handlers，使用Collections.unmodifiableList创建一个不可修改的视图
        List<TransHandler> unmodifiableHandlers = Collections.unmodifiableList(handlers);

        // 使用增强for循环遍历，减少对列表的直接访问
        for (int i = 0; i < unmodifiableHandlers.size() - 1; i++) {
            unmodifiableHandlers.get(i).setNextHandler(unmodifiableHandlers.get(i + 1));
        }
        // 返回链的第一个处理器
        return unmodifiableHandlers.get(0);
    }
}
