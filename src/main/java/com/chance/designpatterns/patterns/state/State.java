package com.chance.designpatterns.patterns.state;

/**
 * <p> State </p>
 *
 * @author chance
 * @date 2023/9/6 15:08
 * @since 1.0
 */
public interface State {

    void turnOn(Fan fan);

    void turnOff(Fan fan);

    void increaseSpeed(Fan fan);

    void decreaseSpeed(Fan fan);
}
