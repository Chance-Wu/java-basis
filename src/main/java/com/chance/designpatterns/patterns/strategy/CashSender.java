package com.chance.designpatterns.patterns.strategy;

/**
 * <p>
 * 现金发放
 * <p>
 *
 * @author chance
 * @since 2020-07-20
 */
public class CashSender implements PrizeSender {
    @Override
    public boolean support(SendPrizeRequest request) {
        return PrizeTypeEnum.CASH.getValue() == request.getPrizeType();
    }

    @Override
    public void sendPrize(SendPrizeRequest request) {
        System.out.println("发放现金");
    }
}
