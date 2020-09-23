package com.chance.designpatterns.patterns.factory;

import com.chance.designpatterns.patterns.factory.store.ICommodity;
import com.chance.designpatterns.patterns.factory.store.impl.CardCommodityServiceImpl;
import com.chance.designpatterns.patterns.factory.store.impl.CouponCommodityServiceImpl;
import com.chance.designpatterns.patterns.factory.store.impl.GoodsCommodityServiceImpl;
import org.junit.Test;

/**
 * <p>
 * 商店工厂类
 * <p>
 * 在里面按照类型实现各种商品的服务。可以非常干净整洁的处理你的代码，后续新增的商品在这里扩展即可。
 * 如果你不喜欢if判断，也可以使用switch或者map配置结构，会让代码更加干净。
 * <p>
 *
 * @author chance
 * @since 2020-09-15
 */
public class StoreFactory {

    public ICommodity createCommodityService(Integer commodityType) {
        ICommodity commodity = null;
        if (commodityType == null) {
            commodity = null;
        }
        if (1 == commodityType) {
            commodity = new CouponCommodityServiceImpl();
        } else if (2 == commodityType) {
            commodity = new GoodsCommodityServiceImpl();
        } else if (3 == commodityType) {
            commodity = new CardCommodityServiceImpl();
        }
        return commodity;
    }
}
