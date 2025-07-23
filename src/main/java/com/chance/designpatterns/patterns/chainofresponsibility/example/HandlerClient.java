package com.chance.designpatterns.patterns.chainofresponsibility.example;

/**
 * @author chance
 * @date 2024/6/20 09:44
 * @since 1.0
 */
public class HandlerClient {

    public static void main(String[] args) {
        //第一关
        FirstPassHandler firstPassHandler = new FirstPassHandler();
        //第二关
        SecondPassHandler secondPassHandler = new SecondPassHandler();
        //第三关
        ThirdPassHandler thirdPassHandler = new ThirdPassHandler();

        // 构建责任链
        // 第一关的下一关是第二关
        firstPassHandler.setSecondPassHandler(secondPassHandler);
        // 第二关的下一关是第三关
        secondPassHandler.setThirdPassHandler(thirdPassHandler);

        //开始调用第一关 每一个关卡是否进入下一关卡 在每个关卡中判断
        firstPassHandler.handle();
    }
}
