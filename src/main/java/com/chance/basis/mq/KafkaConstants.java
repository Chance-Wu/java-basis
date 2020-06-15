package com.chance.basis.mq;

/**
 * <p>
 * KafkaConstants常量类中定义了Kafka一些常用配置常量
 * <p>
 *
 * @author chance
 * @since 2020-05-11
 */
public class KafkaConstants {

    /**
     * 代理集合，broker可以看作是一个独立的Kafka实例
     */
    public static final String BROKER_LIST = "localhost:9092";

    /**
     * Kafka客户端ID
     */
    public static final String CLIENT_ID = "client1";
    /**
     * 消费组ID
     */
    public static String GROUP_ID_CONFIG = "consumerGroup1";

    private KafkaConstants() {

    }
}
