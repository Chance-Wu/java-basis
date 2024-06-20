package com.chance.designpatterns.patterns.chainofresponsibility.example.optimize;

/**
 * @author: chance
 * @date: 2024/6/20 10:32
 * @since: 1.0
 */
public class HandlerClient {

    public static void main(String[] args) {
        //第一关
        FirstPassHandler firstPassHandler = new FirstPassHandler();
        //第二关
        SecondPassHandler secondPassHandler = new SecondPassHandler();
        //第三关
        ThirdPassHandler thirdPassHandler = new ThirdPassHandler();

        //第一关的下一关是第二关
        firstPassHandler.setNext(secondPassHandler);
        //第二关的下一关是第三关
        secondPassHandler.setNext(thirdPassHandler);

        //说明：因为第三关是最后一关，因此没有下一关

        //从第一个关卡开始
        firstPassHandler.handle();
    }
}
