package com.chance.toolkit.gson.deserialization;

import com.chance.toolkit.gson.GsonUtil;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

/**
 * <p>
 * 借助java类，生成对应java对象来解析数据
 * <p>
 *
 * @author chance
 * @since 2020-07-10
 */
public class ParseJsonObjectByJavabean {

    public static void main(String[] args) {
        String json = "{\"name\":\"tom\",\"salary\":2999}";

        Gson gson = GsonUtil.getGsonInstance();
        MyEntry myEntry = gson.fromJson(json, MyEntry.class);

        // 对于不完整的json数据，映射了相应的java类之后，转化得到的java对象，未赋值的字段都是默认值。
        System.out.println(myEntry.toString());

        // 如果前端传来的json数据的key和java类的字段不一致，使用@SerializedName()注解
        String json2 = "{\"name\":\"tom\",\"money\":2999}";
        MyEntry myEntry1 = gson.fromJson(json2, MyEntry.class);
        System.out.println(myEntry1.toString());


        //
        String json3 = "{\n" +
                "  \"name\": \"tom\",\n" +
                "  \"age\": 0,\n" +
                "  \"money\": 2999,\n" +
                "  \"hobbies\": [\n" +
                "    \"basket\",\n" +
                "    \"tennis\"\n" +
                "  ],\n" +
                "  \"collections\": {\n" +
                "    \"2\": \"paint\",\n" +
                "    \"3\": \"mouse\"\n" +
                "  }\n" +
                "}";
        MyEntry myEntry2 = gson.fromJson(json3, MyEntry.class);
        System.out.println(myEntry2.toString());

        // json是数组类型
        String json4 = "[\"apple\", \"banana\", \"pear\"]";
        String[] strings = gson.fromJson(json4, String[].class);
        System.out.println(strings[0]);
        // 使用泛型
        List<String> fruitList = gson.fromJson(json4, new TypeToken<List<String>>() {
        }.getType());
        System.out.println(fruitList);

        String typeJson1 = "{\n" +
                "  \"code\":0,\n" +
                "  \"message\":\"success\",\n" +
                "  \"data\":{\n" +
                "    \"name\":\"tom\",\n" +
                "    \"age\":32,\n" +
                "    \"address\":\"street one\",\n" +
                "    \"salary\":4999\n" +
                "  }\n" +
                "}";
        // 动态生成所需的java类的类型
        Type type1 = new TypeToken<Result<MyEntry>>() {
        }.getType();
        // 动态生成java对象
        Result<MyEntry> result1 = gson.fromJson(typeJson1, type1);
        System.out.println(result1);

        String typeJson2 = "{\n" +
                "  \"code\": 0,\n" +
                "  \"message\": \"success\",\n" +
                "  \"data\": [\n" +
                "    {\n" +
                "      \"name\": \"tom\",\n" +
                "      \"age\": 32,\n" +
                "      \"address\": \"street one\",\n" +
                "      \"salary\": 4999\n" +
                "    },\n" +
                "    {\n" +
                "      \"name\": \"lucy\",\n" +
                "      \"age\": 24,\n" +
                "      \"address\": \"street three\",\n" +
                "      \"salary\": 2333\n" +
                "    }\n" +
                "  ]\n" +
                "}";
        // 再次动态生成java类型
        Type type2 = new TypeToken<Result<List<MyEntry>>>() {
        }.getType();
        // 再次动态生成java对象
        Result<List<MyEntry>> result2 = gson.fromJson(typeJson2, type2);
        System.out.println(result2);
    }
}
