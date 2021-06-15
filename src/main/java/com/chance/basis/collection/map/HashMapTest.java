package com.chance.basis.collection.map;

import java.util.HashMap;

/**
 * @Description: HashMapTest
 * @Author: chance
 * @Date: 1/8/21 6:30 PM
 * @Version 1.0
 */
public class HashMapTest {

    public static void main(String[] args) {
//        Map<String, String> map = new HashMap<>(16);
//        map.put("3", "杰克");
//        map.put("2", "露西");
//        map.put("4", "德玛");
//        map.put("6", "杰森");
//        map.put("5", "南希");
//        map.put("1", "提莫");
//
//        for (Map.Entry<String, String> entry : map.entrySet()) {
//            System.out.println(entry);
//        }
//
//        Set<String> keySet = map.keySet();
//        Collections.sort(new ArrayList<>(keySet));
//
//        Iterator<String> iterator = keySet.iterator();
//        while (iterator.hasNext()) {
//            String key = iterator.next();
//            System.out.println("key-value：" + key + "-" + map.get(key));
//        }
//
//        Collections.sort(new ArrayList<>(keySet), (o1, o2) -> {
//            if (Integer.parseInt(o1) > Integer.parseInt(o2)) {
//                return 1;
//            }
//            if (Integer.parseInt(o1) == Integer.parseInt(o2)) {
//                return 0;
//            } else {
//                return -1;
//            }
//        });

        HashMap<String,String> map = new HashMap<>(16);
        map.put("1", "123");
        System.out.println(map);
    }
}
