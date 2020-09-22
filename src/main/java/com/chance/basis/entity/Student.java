package com.chance.basis.entity;

/**
 * @Description: Student
 * @Author: chance
 * @Date: 2020-09-22 09:06
 * @Version 1.0
 */
public class Student extends Person {

    private String school;

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    @Override
    public String getInfo() {
        return "name:"+super.getName()+","+"weight:"+super.getWeigth()+","+"school:"+this.school;
    }
}
