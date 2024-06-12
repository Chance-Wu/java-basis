package com.chance.designpatterns.patterns.state;

/**
 * <p> Concrete States </p>
 *
 * @author chance
 * @date 2023/9/6 15:10
 * @since 1.0
 */
public class OffState implements State {
    @Override
    public void turnOn(Fan fan) {

    }

    @Override
    public void turnOff(Fan fan) {
        System.out.println("Turning on the fan.");
        fan.setState(new LowSpeedState());
    }

    @Override
    public void increaseSpeed(Fan fan) {

    }

    @Override
    public void decreaseSpeed(Fan fan) {

    }
}
