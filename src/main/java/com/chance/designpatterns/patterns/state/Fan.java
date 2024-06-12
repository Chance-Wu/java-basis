package com.chance.designpatterns.patterns.state;

/**
 * <p> Context </p>
 *
 * @author chance
 * @date 2023/9/6 15:07
 * @since 1.0
 */
public class Fan {
    private State state;

    public Fan() {
        // 初始状态为关闭状态
        this.state = new OffState();
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public void turnOn() {
        state.turnOn(this);
    }

    public void turnOff() {
        state.turnOff(this);
    }

    public void increaseSpeed() {
        state.increaseSpeed(this);
    }

    public void decreaseSpeed() {
        state.decreaseSpeed(this);
    }
}
