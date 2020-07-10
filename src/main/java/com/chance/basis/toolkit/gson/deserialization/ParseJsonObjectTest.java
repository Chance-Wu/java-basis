package com.chance.basis.toolkit.gson.deserialization;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/**
 * <p>
 * 不借助java类，直接解析json数据
 * <p>
 * json是对象类型
 * <p>
 *
 * @author chance
 * @since 2020-07-09
 */
public class ParseJsonObjectTest {

    public static void main(String[] args) {
        String json = "{\n" +
                "        \"sex\": '男',\n" +
                "        \"hobby\":[\"baskte\",\"tennis\"],\n" +
                "        \"introduce\": {\n" +
                "            \"name\":\"tom\",\n" +
                "            \"age\":23\n" +
                "        }\n" +
                "    }";

        // json解析器，解析json数据
        JsonParser jsonParser = new JsonParser();
        JsonElement jsonElement = jsonParser.parse(json);

        // json属于对象类型时
        if (jsonElement.isJsonObject()) {
            // 转化为对象
            JsonObject object = jsonElement.getAsJsonObject();

            // 1. value为string时，取出string
            String sex = object.get("sex").getAsString();
            System.out.println("sex:" + sex);

            // 2. value为array时，取出array
            JsonArray hobbies = object.getAsJsonArray("hobby");
            for (int i = 0; i < hobbies.size(); i++) {
                String hobby = hobbies.get(i).getAsString();
                System.out.println("hobby:" + hobby);
            }

            // 3. value为object时，取出object
            JsonObject introduce = object.getAsJsonObject("introduce");
            String name = introduce.get("name").getAsString();
            int age = introduce.get("age").getAsInt();
            System.out.println("name:" + name + ";age:" + age);
        }
    }
}
