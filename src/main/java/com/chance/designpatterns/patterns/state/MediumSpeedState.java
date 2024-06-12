package com.chance.designpatterns.patterns.state;

/**
 * <p> Concrete States </p>
 *
 * @author chance
 * @date 2023/9/6 15:13
 * @since 1.0
 */
public class MediumSpeedState implements State {
    @Override
    public void turnOn(Fan fan) {

    }

    @Override
    public void turnOff(Fan fan) {

    }

    @Override
    public void increaseSpeed(Fan fan) {

    }

    @Override
    public void decreaseSpeed(Fan fan) {
        System.out.println("Decreasing fan speed to low.");
        fan.setState(new LowSpeedState());
    }
}
