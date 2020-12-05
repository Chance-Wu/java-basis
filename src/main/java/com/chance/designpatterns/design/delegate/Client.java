package com.chance.designpatterns.design.delegate;

/**
 * <p>
 * 客户端 ——> 委派任务
 * <p>
 *
 * @author chance
 * @since 2020-09-11
 */
public class Client {

    public static void main(String[] args) {
        String command1 = "code1";
        String command2 = "code2";
        String command3 = "test";
        Delegator delegator = new Delegator();
        delegator.execute(command1);
        delegator.execute(command2);
        delegator.execute(command3);
    }
}
