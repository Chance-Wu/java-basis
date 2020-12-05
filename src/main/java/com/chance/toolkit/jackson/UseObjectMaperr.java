package com.chance.toolkit.jackson;

import com.chance.basis.entity.Person;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

/**
 * @Description: UseObjectMaperr
 * @Author: chance
 * @Date: 12/5/20 10:33 AM
 * @Version 1.0
 */
public class UseObjectMaperr {

    public static void main(String[] args) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        // 设置ObjectMapper的相关配置信息
        // 在反序列化是忽略在 json 中存在但 Java对象不存在的属性
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        // 在序列化是日期格式默认为 yyyy-MM-dd'T'HH:mm:ss.SSSZ
        objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        // 在序列化时忽略值为 null 的属性
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        // 忽略值为默认值的属性
        objectMapper.setDefaultPropertyInclusion(JsonInclude.Include.NON_DEFAULT);

        Person person = new Person();
        person.setName("Tom");
        person.setWeigth(40);
        // 序列化为json
        String jsonString = objectMapper.writerWithDefaultPrettyPrinter()
                .writeValueAsString(person);
        // 反序列化为对象
        Person deserializedPerson = objectMapper.readValue(jsonString, Person.class);
        System.out.println(jsonString);
        System.out.println(deserializedPerson);
    }
}
