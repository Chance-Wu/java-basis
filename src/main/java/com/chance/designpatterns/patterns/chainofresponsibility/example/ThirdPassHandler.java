package com.chance.designpatterns.patterns.chainofresponsibility.example;

/**
 * @author: 第三关
 * @date: 2024/6/20 09:34
 * @since: 1.0
 */
public class ThirdPassHandler {

    /**
     * 本关卡游戏得分
     *
     * @return
     */
    private int play() {
        return 95;
    }

    /**
     * 这是最后一关，因此没有下一关
     */
    public int handle() {
        System.out.println("第三关-->ThirdPassHandler，这是最后一关啦");
        return play();
    }
}
