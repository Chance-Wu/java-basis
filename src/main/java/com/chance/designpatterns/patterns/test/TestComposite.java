package com.chance.designpatterns.patterns.test;

import com.chance.designpatterns.patterns.composite.Composite;
import com.chance.designpatterns.patterns.composite.Leaf;

/**
 * @Description: TestComposite
 * @Author: chance
 * @Date: 12/25/20 2:10 PM
 * @Version 1.0
 */
public class TestComposite {

    public static void main(String[] args) {
        // 生成树根 root， 根上长出两叶
        Composite root = new Composite("root");
        root.add(new Leaf("Leaf A"));
        root.add(new Leaf("Leaf B"));

        root.display(1);
    }
}
