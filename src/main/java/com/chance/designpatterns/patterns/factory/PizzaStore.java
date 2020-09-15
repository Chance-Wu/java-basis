package com.chance.designpatterns.patterns.factory;

import com.chance.designpatterns.patterns.factory.bean.Pizza;

/**
 * <p>
 * 客户
 * <p>
 *
 * @author chance
 * @since 2020-02-24
 */
public class PizzaStore {

    /**
     * 创建一个对SimplePizzaFactory的引用
     */
    SimplePizzaFactory factory;

    /**
     * 构造器，需要时一个工厂作为参数
     * @param factory
     */
    public PizzaStore(SimplePizzaFactory factory) {
        this.factory = factory;
    }

    /**
     * 通过传入简单订单类型来使用工厂创建比萨
     * @param type
     * @return
     */
    public Pizza oderPizza(String type) {
        Pizza pizza;
        //这里不再使用具体实例化
        pizza = factory.createPizza(type);

        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();

        return pizza;
    }
}
