package com.chance.basis.collection.list.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Description: Test
 * @Author: chance
 * @Date: 1/4/21 9:18 AM
 * @Version 1.0
 */
public class Test {

    public static void main(String[] args) {
        Student s1 = new Student();
        s1.setId(10001);
        s1.setName("cat");
        s1.setScore(99.5f);

        Student s2 = new Student();
        s2.setId(10008);
        s2.setName("bba");
        s2.setScore(100.0f);

        Student s3 = new Student();
        s3.setId(10011);
        s3.setName("bac");
        s3.setScore(89.5f);

        Student s4 = new Student();
        s4.setId(10009);
        s4.setName("bad");
        s4.setScore(89.5f);

        List<Student> list = new ArrayList<>();
        list.add(s1);
        list.add(s2);
        list.add(s3);
        list.add(s4);

        System.out.println("排序之前-----------------------");
        for (Student stu : list) {
            System.out.println("id=" + stu.getId() + " name=" + stu.getName() + " score=" + stu.getScore());
        }

        // 方式一：利用集合工具类Collections的`sort(List<T> list, Comparator<? super T> c)`方法，自定义比较器对象对指定对象进行排序。
        Collections.sort(list, new StudentComparator());

        System.out.println("排序之后-----------------------");
        for (Student stu : list) {
            System.out.println("id=" + stu.getId() + " name=" + stu.getName() + " score=" + stu.getScore());
        }

        List<Person> listA = new ArrayList();
        Person p1 = new Person();
        Person p2 = new Person();
        Person p3 = new Person();

        p1.setName("name1");
        p1.setOrder(1);
        p2.setName("name2");
        p2.setOrder(2);
        p3.setName("name3");
        p3.setOrder(3);

        listA.add(p2);
        listA.add(p1);
        listA.add(p3);

        // 方式二：通过实现Comparable接口来实现list的排序
        Collections.sort(listA);

        //打印排序后的Person
        for (Person p : listA) {
            System.out.println(p.getName());
        }
    }
}
