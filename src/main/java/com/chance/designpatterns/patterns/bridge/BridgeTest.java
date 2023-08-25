package com.chance.designpatterns.patterns.bridge;

/**
 * <p> BridgeTest </p>
 *
 * @author chance
 * @date 2023/8/23 14:52
 * @since 1.0
 */
public class BridgeTest {
    public static void main(String[] args) {
        Implementor imple = new ConcreteImplementorA();
        Abstraction abs = new RefinedAbstraction(imple);
        abs.operation();
    }
}
