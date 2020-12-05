package com.chance.designpatterns.patterns.strategy;

/**
 * <p>
 * 策略模式
 * 使用多态的方式进行奖励发放
 *
 * 抽象出一个奖品发放的接口
 * <p>
 *
 * @author chance
 * @since 2020-07-20
 */
public interface PrizeSender {

    /**
     * 用于判断当前实例是否支持当前奖励的发放
     */
    boolean support(SendPrizeRequest request);

    /**
     * 发放奖励
     */
    void sendPrize(SendPrizeRequest request);
}
