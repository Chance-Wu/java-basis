package com.chance.basis.initialization;

import org.junit.Test;

/**
 * @Description: StaticCodeBlockTest
 * @Author: chance
 * @Date: 2020-09-22 16:49
 * @Version 1.0
 */
public class StaticCodeBlockTest {

    @Test
    public void test() {
        System.out.println("创建对象");
        Demo demo = new Demo();
        System.out.println(demo.getId());
    }
}
