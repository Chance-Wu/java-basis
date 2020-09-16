package com.chance.designpatterns.patterns.factory.store;

import java.util.Map;

/**
 * <p>
 * 发奖接口
 *
 * 所有的奖品无论是实物、虚拟还是第三方，都需要通过我们的程序实现此接口进行处理，以保证最终入参出参的统一性。
 *
 * 接口的入参包括：用户ID、奖品ID、业务ID以及扩展字段用于处理发放实物商品时的收货地址。
 * <p>
 *
 * @author chance
 * @since 2020-09-15
 */
public interface ICommodity {
    void sendCommodity(String uId, String commodityId, String bizId, Map<String,String> extMap);
}
