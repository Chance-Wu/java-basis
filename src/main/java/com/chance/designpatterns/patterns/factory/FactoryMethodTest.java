package com.chance.designpatterns.patterns.factory;

import com.chance.designpatterns.patterns.factory.store.ICommodity;
import org.junit.Test;

/**
 * @Description: FactoryMethodTest
 * @Author: chance
 * @Date: 2020-09-23 09:48
 * @Version 1.0
 */
public class FactoryMethodTest {

    @Test
    public void test() {
        StoreFactory factory = new StoreFactory();
        ICommodity commodity = factory.createCommodityService(1);
    }
}
