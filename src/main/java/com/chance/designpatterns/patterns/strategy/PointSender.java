package com.chance.designpatterns.patterns.strategy;

/**
 * <p>
 * 积分发放
 * <p>
 *
 * @author chance
 * @since 2020-07-20
 */
public class PointSender implements PrizeSender {
    @Override
    public boolean support(SendPrizeRequest request) {
        return request.getPrizeType() == PrizeTypeEnum.POINT.getValue();
    }

    @Override
    public void sendPrize(SendPrizeRequest request) {
        System.out.println("发放积分");
    }
}
