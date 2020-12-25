package com.chance.designpatterns.patterns.test;

import com.chance.designpatterns.patterns.adapter.TurkeyAdapter;
import com.chance.designpatterns.patterns.adapter.WildTurkey;

/**
 * @Description: TestAdapter
 * @Author: chance
 * @Date: 12/22/20 9:21 AM
 * @Version 1.0
 */
public class TestAdapter {

    public static void main(String[] args) {

        // 创建一只火鸡
        WildTurkey turkey = new WildTurkey();
        // 将火鸡包装进一个火鸡适配器中，使它看起来像是一支鸭子
        TurkeyAdapter turkeyAdapter = new TurkeyAdapter(turkey);

        // 接着测试这只火鸡，让它咯咯叫，让它飞行
        System.out.println("The Turkey says...");
        turkey.gobble();
        turkey.fly();

        // 试着传入一个假装是鸭子的火鸡
        System.out.println("\nThe TurkeyAdapter says...");
        turkeyAdapter.quack();
        turkeyAdapter.fly();
    }
}
