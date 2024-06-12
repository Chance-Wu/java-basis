package com.chance.designpatterns.patterns.state;

/**
 * <p> Concrete States </p>
 *
 * @author chance
 * @date 2023/9/6 15:12
 * @since 1.0
 */
public class LowSpeedState implements State {
    @Override
    public void turnOn(Fan fan) {

    }

    @Override
    public void turnOff(Fan fan) {
        System.out.println("Turning off the fan.");
        fan.setState(new OffState());
    }

    @Override
    public void increaseSpeed(Fan fan) {
        System.out.println("Increasing fan speed to medium.");
        fan.setState(new MediumSpeedState());
    }

    @Override
    public void decreaseSpeed(Fan fan) {

    }
}
