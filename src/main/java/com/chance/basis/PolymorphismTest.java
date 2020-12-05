package com.chance.basis;

import com.chance.basis.entity.Person;
import com.chance.basis.entity.Student;
import org.junit.Test;

/**
 * @Description: Polymorphism
 * @Author: chance
 * @Date: 2020-09-22 09:05
 * @Version 1.0
 */
public class PolymorphismTest {

    @Test
    public void test() {
        Person person = new Person();
        person.getInfo();
        Student student = new Student();
        student.getInfo();

        // 向上转型
        Person student1 = new Student();
//        student.getSchool();非法，Person类中没有school成员变量
        String info = student1.getInfo();
        System.out.println(info);
        System.out.println(student instanceof Person);
        System.out.println(student instanceof Student);
        System.out.println(person instanceof Student);
    }
}
