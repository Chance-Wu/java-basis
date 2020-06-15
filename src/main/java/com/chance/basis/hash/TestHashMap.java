package com.chance.basis.hash;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *
 * <p>
 *
 * @author chance
 * @since 2020-01-29
 */
public class TestHashMap {
    public static void main(String[] args) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("a", "rrr1");
        map.put("b", "tt9");
        map.put("c", "tt8");
        map.put("d", "g7");
        map.put("e", "d6");
        map.put("f", "d4");
        map.put("g", "d4");
        map.put("h", "d3");
        map.put("i", "d2");
        map.put("j", "d1");
        map.put("k", "1");
        map.put("o", "2");
        map.put("p", "3");
        map.put("q", "4");
        map.put("r", "5");
        map.put("s", "6");
        map.put("t", "7");
        map.put("u", "8");
        map.put("v", "9");

        //HashMap非线程安全的，使用sychronizedMap创建线程安全的HashMap
        Map<Object, Object> map1 = Collections.synchronizedMap(new HashMap<>(16));
    }
}
