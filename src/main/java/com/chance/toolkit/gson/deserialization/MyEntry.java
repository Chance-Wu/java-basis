package com.chance.toolkit.gson.deserialization;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

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
@Data
public class MyEntry {

    /**
     * name字段不参加序列化和反序列化
     */
    @Expose(serialize=false,deserialize=false)
    private String name;
    private int age;
    private String address;

    /**
     * 如果前端传来的json数据的key和java类的字段不一致，使用@SerializedName()注解
     */
    @SerializedName("salary")
    private int salary;

    private List<String> hobbies;
    private Map<Integer,String> collections;
}
