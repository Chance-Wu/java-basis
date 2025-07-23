package com.chance.designpatterns.patterns.chainofresponsibility;

import java.util.ArrayList;
import java.util.List;

/**
 * 用于构建责任链。
 *
 * @author chance
 * @date 2024/6/12 14:40
 * @since 1.0
 */
public class ChainBuilder {
    private final List<TransHandler> handlers;

    public ChainBuilder() {
        this.handlers = new ArrayList<>();
    }

    public ChainBuilder addHandler(TransHandler handler) {
        handlers.add(handler);
        // 支持链式调用来添加多个处理器
        return this;
    }

    public TransHandler build() {
        // 链接所有处理器
        for (int i = 0; i < handlers.size() - 1; i++) {
            handlers.get(i).setNext(handlers.get(i + 1));
        }
        // 返回链的第一个处理器
        return handlers.get(0);
    }
}
