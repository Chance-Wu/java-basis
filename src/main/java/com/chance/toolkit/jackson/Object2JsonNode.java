package com.chance.toolkit.jackson;

import com.chance.basis.entity.Car;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @Description: Object2JsonNode
 * @Author: chance
 * @Date: 12/5/20 3:49 PM
 * @Version 1.0
 */
public class Object2JsonNode {

    public static void main(String[] args) {
        ObjectMapper objectMapper = new ObjectMapper();
        Car car = new Car();
        car.setBrand("Cadillac");
        car.setDoors(4);

        JsonNode jsonNode = objectMapper.valueToTree(car);

        System.out.println(jsonNode.get("brand"));
    }
}
