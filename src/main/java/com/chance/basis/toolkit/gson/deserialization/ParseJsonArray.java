package com.chance.basis.toolkit.gson.deserialization;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/**
 * <p>
 * 不借助java类，直接解析json数据
 * <p>
 * json是数组类型
 * <p>
 *
 * @author chance
 * @since 2020-07-09
 */
public class ParseJsonArray {

    public static void main(String[] args) {
        String json = "[\n" +
                "    \"cake\",\n" +
                "    2,\n" +
                "    {\"brother\":\"tom\",\"sister\":\"lucy\"},\n" +
                "    [\"red\",\"orange\"]\n" +
                "]";

        // json解析器，解析json数据
        JsonParser jsonParser = new JsonParser();
        JsonElement jsonElement = jsonParser.parse(json);

        if (jsonElement.isJsonArray()) {
            JsonArray array = jsonElement.getAsJsonArray();

            // 1. value为string时，取出string
            String array_1 = array.get(0).getAsString();
            System.out.println("array_1:" + array_1);

            // 2. value为int时，取出int
            int array_2 = array.get(1).getAsInt();
            System.out.println("array_2:" + array_2);

            // 3. value为object时，取出object
            JsonObject array_3 = array.get(2).getAsJsonObject();
            String brother = array_3.get("brother").getAsString();
            String sister = array_3.get("sister").getAsString();
            System.out.println("brother:" + brother + ";sister:" + sister);

            // 4. value为array时，取出array
            JsonArray array_4 = array.get(3).getAsJsonArray();
            for (int i = 0; i < array_4.size(); i++) {
                System.out.println(array_4.get(i).getAsString());
            }

        }
    }
}
