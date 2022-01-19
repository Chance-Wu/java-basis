package com.chance.basis.introspector;

import java.util.Date;

/**
 * @Description: Person JavaBean
 * @Author: chance
 * @Date: 2022/1/18 2:47 下午
 * @Version 1.0
 */
public class Person {

    private String name;
    private String password;
    private int age;
    private Date birthday;

    /**
     * ab也是bean中的一个属性
     */
    public String getAb() {
        return null;
    }

    public void setAb() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
