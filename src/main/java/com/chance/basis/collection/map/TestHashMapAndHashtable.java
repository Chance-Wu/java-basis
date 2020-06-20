package com.chance.basis.collection.map;

import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;

/**
 * <p>
 * 需要用到同步时用HashTable，不需要同步时用HashMap。
 *
 * HashMap可以通过调用Collections的静态方法Collections.synchronizedMap(Map map)进行同步
 * <p>
 *
 * @author chance
 * @since 2020-02-06
 */
public class TestHashMapAndHashtable {

    public static void main(String[] args) {

        /**
         * HashMap线程不安全的，效率高于Hashtable
         *
         * 将键映射到值的对象，其中键和值都是对象
         *
         * 数组 + 链表（解决hash冲突）
         */
        HashMap<Object, Object> hashMap = new HashMap<>(6);
        hashMap.put("1", "1");
        // 1.不能包含重复建，相同的key在Map中只会有一个与之关联的value存在
        hashMap.put("1", "2");
        // 2.允许null键和null值
        hashMap.put(null, null);

        Collections.synchronizedMap(hashMap);

        System.out.println(hashMap);


        /**
         * Hashtable线程安全
         *
         * 继承自Dictionary类
         *
         * 其方法都是synchronize的
         */
        Hashtable<Object, Object> hashtable = new Hashtable<>();
        hashtable.put("1", "1");
        hashtable.put("1", "2");
        // 不允许null键null值
//        hashtable.put(null, null);

        System.out.println(hashtable);
    }
}







