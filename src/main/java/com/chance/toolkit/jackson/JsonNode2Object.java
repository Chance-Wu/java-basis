package com.chance.toolkit.jackson;

import com.chance.basis.entity.Car;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @Description: JsonNode2Object
 * @Author: chance
 * @Date: 12/5/20 3:52 PM
 * @Version 1.0
 */
public class JsonNode2Object {

    public static void main(String[] args) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();

        String carJson = "{ \"brand\" : \"Mercedes\", \"doors\" : 5 }";
        JsonNode carJsonNode = objectMapper.readTree(carJson);

        Car car = objectMapper.treeToValue(carJsonNode, Car.class);

        System.out.println(car);
    }
}
