package com.chance.designpatterns.patterns.chainofresponsibility.example;

/**
 * @author: 第一关
 * @date: 2024/6/20 09:34
 * @since: 1.0
 */
public class FirstPassHandler {

    /**
     * 第一关的下一关是 第二关
     */
    private SecondPassHandler secondPassHandler;

    public void setSecondPassHandler(SecondPassHandler secondPassHandler) {
        this.secondPassHandler = secondPassHandler;
    }

    /**
     * 本关卡游戏得分
     *
     * @return
     */
    private int play() {
        return 80;
    }

    public int handle() {
        System.out.println("第一关-->FirstPassHandler");
        if (play() >= 80) {
            //分数>=80 并且存在下一关才进入下一关
            if (this.secondPassHandler != null) {
                return this.secondPassHandler.handle();
            }
        }
        return 80;
    }
}
