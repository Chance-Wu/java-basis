package com.chance.toolkit.jackson;

import com.chance.basis.entity.Employee;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.fasterxml.jackson.dataformat.yaml.YAMLGenerator;

import java.io.File;
import java.io.IOException;

/**
 * @Description: Yaml字符串和对象的互转
 * @Author: chance
 * @Date: 12/5/20 4:00 PM
 * @Version 1.0
 */
public class YamlJacksonExample {

    public static void main(String[] args) {
        ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory());

        Employee employee = new Employee("John Doe", "john@doe.com");

        String yamlString = null;
        try {
            // 序列化为yaml格式的字符串对象
            yamlString = objectMapper.writeValueAsString(employee);
            System.out.println(yamlString);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        try {
            // 反序列化为Employee对象
            Employee employee2 = objectMapper.readValue(yamlString, Employee.class);
            System.out.println(employee2);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            //从yaml文件读取数据
            reaedYamlToEmployee();
            //写入yaml文件
            reaedEmployeeToYaml();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 从yaml文件读取数据
     *
     * @throws IOException
     */
    private static void reaedYamlToEmployee() throws IOException {
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        Employee employee = mapper.readValue(new File("src/main/resources/EmployeeYaml.yml"), Employee.class);
        System.out.println(employee.getName() + "********" + employee.getEmail());

    }

    /**
     * 写入yaml文件
     *
     * @throws IOException
     */
    private static void reaedEmployeeToYaml() throws IOException {
        //去掉三个破折号
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory().disable(YAMLGenerator.Feature.WRITE_DOC_START_MARKER));
        //禁用掉把时间写为时间戳
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

        Employee employee = new Employee("test2", "999@qq.com");
        mapper.writeValue(new File("src/main/resources/EmployeeYamlOutput.yml"), employee);
    }
}
