package com.chance.designpatterns.patterns.observer;

/**
 * <p> 观察者 </p>
 *
 * @author chance
 * @date 2023/8/18 16:58
 * @since 1.0
 */
public interface Observer {

    // 观察者至少有一个方法

    /**
     * 更新方法
     */
    void update();
}
