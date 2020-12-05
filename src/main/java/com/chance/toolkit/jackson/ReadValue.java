package com.chance.toolkit.jackson;

import com.chance.basis.entity.Car;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.net.URL;
import java.util.List;
import java.util.Map;

/**
 * @Description: ReadValue
 * @Author: chance
 * @Date: 12/5/20 2:05 PM
 * @Version 1.0
 */
public class ReadValue {

    public static void main(String[] args) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();

        // 从Reader中读取对象
        String carJson = "{\"brand\":\"Mercedes\",\"doors\":4}";
        StringReader reader = new StringReader(carJson);
        Car car = objectMapper.readValue(reader, Car.class);

        // 从File中读取对象
        File file = new File("src/main/resources/car.json");
        System.out.println(file.getAbsolutePath());
        System.out.println(System.getProperty("user.dir"));
        Car car2 = objectMapper.readValue(file, Car.class);

        // 从URL中读取对象
        URL url = new URL("file:/Users/chance/IdeaProjects/java-basis/src/main/resources/car.json");
        Car car3 = objectMapper.readValue(url, Car.class);

        // 从InputStream读取对象
        InputStream inputStream = new FileInputStream("src/main/resources/car.json");
        Car car4 = objectMapper.readValue(inputStream, Car.class);

        // 从字节数组中读取对象
        byte[] bytes = carJson.getBytes("UTF-8");
        Car car5 = objectMapper.readValue(bytes, Car.class);

        // 从JSON数组字符串中读取对象数组
        String jsonArray = "[{\"brand\":\"ford\"}, {\"brand\":\"Fiat\"}]";
        Car[] carArray = objectMapper.readValue(jsonArray, Car[].class);

        // 从JSON数组字符串中读取对象列表
        List<Car> carList = objectMapper.readValue(jsonArray, new TypeReference<List<Car>>() {
        });

        // 从JSON字符串中读取映射为map
        String jsonObject = "{\"brand\":\"ford\",\"doors\":5}";
        Map<String, Object> jsonMap = objectMapper.readValue(jsonObject,
                new TypeReference<Map<String, Object>>() {
                });

        // 树模型
        JsonNode jsonNode = objectMapper.readValue(carJson, JsonNode.class);
        // 或者
        JsonNode jsonNode1 = objectMapper.readTree(carJson);
        JsonNode brandNode = jsonNode.get("brand");
        String brand = brandNode.asText();
        System.out.println("brand = " + brand);

        JsonNode doorsNode = jsonNode.get("doors");
        int doors = doorsNode.asInt();
        System.out.println("doors = " + doors);

        System.out.println(car);
        System.out.println(car2);
        System.out.println(car3);
        System.out.println(car4);
        System.out.println(car5);
        System.out.println(carArray[0]);
        System.out.println(carList.get(0));
        System.out.println(jsonMap);
        System.out.println(jsonNode);

    }
}
