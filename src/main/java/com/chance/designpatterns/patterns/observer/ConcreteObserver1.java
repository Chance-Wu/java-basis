package com.chance.designpatterns.patterns.observer;

/**
 * <p> 具体观察者1 </p>
 *
 * @author chance
 * @date 2023/8/18 16:59
 * @since 1.0
 */
public class ConcreteObserver1 implements Observer {
    @Override
    public void update() {
        System.out.println("观察者1收到消息，进行处理");
    }
}
