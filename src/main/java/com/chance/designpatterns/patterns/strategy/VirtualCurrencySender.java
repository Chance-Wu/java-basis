package com.chance.designpatterns.patterns.strategy;

/**
 * <p>
 * 虚拟币发放
 * <p>
 *
 * @author chance
 * @since 2020-07-20
 */
public class VirtualCurrencySender implements PrizeSender {
    @Override
    public boolean support(SendPrizeRequest request) {
        return PrizeTypeEnum.VIRTUAL_CURRENCY.getValue() == request.getPrizeType();
    }

    @Override
    public void sendPrize(SendPrizeRequest request) {
        System.out.println("发放虚拟币");
    }
}
