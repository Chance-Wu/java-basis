package com.chance.basis.copy;

/**
 * @Description: 深拷贝
 * @Author: chance
 * @Date: 2020-11-02 10:04
 * @Version 1.0
 */
public class Student implements Cloneable {

    String name;
    int age;
    Professor p;

    Student(String name, int age, Professor p) {
        this.name = name;
        this.age = age;
        this.p = p;
    }

    @Override
    public Object clone() {
        Student o = null;
        try {
            o = (Student) super.clone();
        } catch (CloneNotSupportedException e) {
            System.out.println(e.toString());
        }
        o.p = (Professor) p.clone();
        return o;
    }
}
