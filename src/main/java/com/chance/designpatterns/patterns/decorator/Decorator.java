package com.chance.designpatterns.patterns.decorator;

import java.util.ArrayList;
import java.util.ListIterator;

/**
 * @Description: Decorator
 * @Author: chance
 * @Date: 12/28/20 4:36 PM
 * @Version 1.0
 */
public class Decorator implements Work {

    private Work work;

    /**
     * 额外增加的功能被打包在这个List中
     */
    private ArrayList others = new ArrayList();

    /**
     * 在构造器中使用组合new方式,引入Work对象
     */
    public Decorator(Work work) {
        this.work = work;
        others.add("挖坑");
        others.add("钉木板");
    }

    @Override
    public void insert() {
        newMethod();
    }

    /**
     * 在新方法中,我们在insert之前增加其他方法,这里次序先后是用户灵活指定的
     */
    public void newMethod() {
        otherMethod();
        work.insert();
    }

    public void otherMethod() {
        ListIterator listIterator = others.listIterator();
        while (listIterator.hasNext()) {
            System.out.println(listIterator.next() + " 正在进行");
        }
    }
}
