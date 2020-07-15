package com.chance.basis.toolkit.gson.serialization;

import com.chance.basis.toolkit.gson.GsonUtil;
import com.chance.basis.toolkit.gson.deserialization.MyEntry;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *
 * <p>
 *
 * @author chance
 * @since 2020-07-10
 */
public class ObjectToJson {

    public static void main(String[] args) {
        // 对于非值属性，即引用属性，如hobbies、collections，如果没有设置值的话，在序列化后的json数据中，是不会出现的。
        // 而如果是值属性，没有设置值的情况下，在json数据中会是使用java中的默认值
        MyEntry entry = new MyEntry();
        entry.setName("tom");
        entry.setSalary(2999);
        List<String> hobbies = new ArrayList<>();
        hobbies.add("basket");
        hobbies.add("tennis");
        entry.setHobbies(hobbies);
//        Map<Integer, String> collections = new HashMap<>();
//        collections.put(2, "paint");
//        collections.put(3, "mouse");
//        entry.setCollections(collections);
        Gson gson = GsonUtil.getGsonInstance();
        String json = gson.toJson(entry);
        System.out.println(json);
    }
}
