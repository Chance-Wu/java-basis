package com.chance.basis.callback;

import org.junit.Test;

import java.util.List;

/**
 * @Description: CallbackTest
 * @Author: chance
 * @Date: 2020-09-23 13:11
 * @Version 1.0
 */
public class CallbackTest {

    @Test
    public void test() {
        A a = new A();
        // 实现词库元素的删除
        a.execute(new CallBackInterface() {
            @Override
            public Object process(List param) {
                List<String> wordList = param;
                wordList.remove("1");
                return true;
            }
        });

        // 实现词库元素的增加
        a.execute(new CallBackInterface() {
            @Override
            public Object process(List param) {
                List<String> wordList = param;
                wordList.add("24");
                return true;
            }
        });
    }
}
