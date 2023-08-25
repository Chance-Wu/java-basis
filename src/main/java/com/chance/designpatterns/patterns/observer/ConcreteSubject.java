package com.chance.designpatterns.patterns.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * <p> 具体被观察者 </p>
 *
 * @author chance
 * @date 2023/8/18 16:55
 * @since 1.0
 */
public class ConcreteSubject implements Subject {

    /**
     * 观察者数组
     */
    private List<Observer> observers = new ArrayList<>();

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyAllObserver() {
        for (Observer observer : observers) {
            observer.update();
        }
    }

    @Override
    public void doSomething() {
        System.out.println("具体目标发生改变");
        this.notifyAllObserver();
    }
}
