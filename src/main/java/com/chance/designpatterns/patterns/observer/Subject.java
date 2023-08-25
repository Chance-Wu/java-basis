package com.chance.designpatterns.patterns.observer;

/**
 * <p> 被观察者 </p>
 *
 * @author chance
 * @date 2023/8/18 16:51
 * @since 1.0
 */
public interface Subject {

    //被观察者至少有三个方法

    /**
     * 添加监听者
     * @param observer
     */
    void registerObserver(Observer observer);

    /**
     * 删除监听者
     * @param observer
     */
    void removeObserver(Observer observer);

    /**
     * 通知监听者
     */
    void notifyAllObserver();

    abstract void doSomething();
}
