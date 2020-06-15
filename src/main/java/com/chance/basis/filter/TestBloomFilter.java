package com.chance.basis.filter;

/**
 * <p>
 * 测试布隆过滤器
 * <p>
 *
 * @author chance
 * @since 2020-04-07
 */
public class TestBloomFilter {
    public static void main(String[] args) {
        String value1 = "https://javaguide.cn/";
        String value2 = "https://github.com/Snailclimb";

        BloomFilter filter = new BloomFilter();
        System.out.println(filter.contains(value1));
        System.out.println(filter.contains(value2));
        filter.add(value1);
        filter.add(value2);
        System.out.println(filter.contains(value1));
        System.out.println(filter.contains(value2));
    }
}
