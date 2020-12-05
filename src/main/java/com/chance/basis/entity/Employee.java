package com.chance.basis.entity;

import lombok.Data;

/**
 * @Description: Employee
 * @Author: chance
 * @Date: 12/5/20 4:03 PM
 * @Version 1.0
 */
@Data
public class Employee {

    public Employee() {
    }

    public Employee(String name, String email) {
        this.name = name;
        this.email = email;
    }

    String name;

    String email;
}