package com.chance.reflection.methodhandle.use;

import java.lang.invoke.MethodHandle;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 实现一个简单的事件总线，用于注册和发布事件
 *
 * @author chance
 * @date 2025/6/4 15:54
 * @since 1.0
 */
public class EventBus {

    /**
     * 存储事件类型与处理方法（MethodHandle）的映射
     * 使用 ConcurrentHashMap 保证线程安全
     */
    private Map<Class<?>, MethodHandle> handlers = new ConcurrentHashMap<>();

    /**
     * 将事件类型与对应的处理方法（MethodHandle）存入一个线程安全的 Map 中
     *
     * @param eventType 事件类型
     * @param handler   处理器
     */
    public void register(Class<?> eventType, MethodHandle handler) {
        handlers.put(eventType, handler);
    }

    /**
     * 根据事件对象的实际类型查找并调用对应的处理方法
     *
     * @param event 事件对象
     */
    public void publish(Object event) throws Throwable {
        MethodHandle handle = handlers.get(event.getClass());
        if (handle != null) {
            handle.invoke(event);
        }
    }
}
