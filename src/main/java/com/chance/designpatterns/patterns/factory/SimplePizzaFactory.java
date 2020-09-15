package com.chance.designpatterns.patterns.factory;

import com.chance.designpatterns.patterns.factory.bean.*;

/**
 * <p>
 * 做比萨的工厂
 * <p>
 *
 * @author chance
 * @since 2020-02-24
 */
public class SimplePizzaFactory {

    /**
     * 首先在工厂中定义一个方法，所有客户用这个方法来实例化新对象
     */
    public Pizza createPizza(String type) {
        Pizza pizza = null;

        if ("cheese".equals(type)) {
            pizza = new CheesePizza();
        } else if ("pepperoni".equals(type)) {
            pizza = new PepperoniPizza();
        } else if ("clam".equals(type)) {
            pizza = new ClamPizza();
        } else if ("veggie".equals(type)) {
            pizza = new VeggiePizza();
        }
        return pizza;
    }
}
