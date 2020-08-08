package com.chance.basis.principles;

/**
 * <p>
 * 依赖倒置原则——DIP
 * <p>
 *
 * @author chance
 * @since 2020-07-17
 */
public class DIPTest {

    /**
     * 定义：高层模块不应该依赖底层模块，两者都应该依赖其抽象 抽象不应该依赖细节 细节应该依赖抽象
     *
     * 在Java 中抽象指的是接口或者抽象类，两者皆不能实例化。而细节就是实现类，也就是实现了接口或者继承了抽象类的类。他是可以被实例化的。高层模块指的是调用端，底层模块是具体的实现类。在Java中，依赖倒置原则是指模块间的依赖是通过抽象来发生的，实现类之间不发生直接的依赖关系，其依赖关系是通过接口是来实现的。这就是俗称的面向接口编程。
     */
}