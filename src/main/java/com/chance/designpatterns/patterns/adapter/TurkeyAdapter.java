package com.chance.designpatterns.patterns.adapter;

/**
 * @Description: 首先实现需要转换成的类型接口
 * @Author: chance
 * @Date: 12/21/20 12:11 PM
 * @Version 1.0
 */
public class TurkeyAdapter implements Duck {

    Turkey turkey;

    /**
     * 取得适配对象的引用，这里我们利用构造器取得这个引用
     */
    public TurkeyAdapter(Turkey turkey) {
        this.turkey = turkey;
    }

    /**
     * 现在我们需要实现接口中所有的方法。
     * quack()在类之间的转换很简单，只要调用gobble()就可以了
     */
    @Override
    public void quack() {
        turkey.gobble();
    }

    /**
     * 固然两个接口都具备了fly()方法，火鸡的飞行距离很短，不像鸭子可以长途飞行。
     *
     * 要让鸭子的飞行和火鸡的飞行能够对应，必须连续五次调用火鸡的fly()来完成。
     */
    @Override
    public void fly() {
        for (int i = 0; i < 5; i++) {
            turkey.fly();
        }
    }
}
