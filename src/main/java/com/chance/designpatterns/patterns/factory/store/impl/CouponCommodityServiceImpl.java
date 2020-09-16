package com.chance.designpatterns.patterns.factory.store.impl;

import com.chance.designpatterns.patterns.factory.store.ICommodity;

import java.util.Map;

/**
 * <p>
 * 发放优惠券
 * <p>
 *
 * @author chance
 * @since 2020-09-15
 */
public class CouponCommodityServiceImpl implements ICommodity {

    @Override
    public void sendCommodity(String uId, String commodityId, String bizId, Map<String, String> extMap) {
        System.out.println("发放卡券商品");
    }
}
