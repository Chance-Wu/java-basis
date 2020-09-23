package com.chance.basis.callback;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: A
 * @Author: chance
 * @Date: 2020-09-23 10:57
 * @Version 1.0
 */
public class A {
    public List<String> wordList = loadList();

    public <T> T execute(CallBackInterface callBackInterface) {
        // 可以先执行一些execute的逻辑
        // 直接将相关对词库的操作权都交给了callbackInterface
        T result = (T) callBackInterface.process(wordList);
        return result;
    }

    /**
     * 加载词库
     *
     * @return
     */
    private List<String> loadList() {
        ArrayList<String> worldList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            worldList.add(Integer.toString(i));
        }
        return worldList;
    }
}
