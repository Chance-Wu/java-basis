package com.chance.basis.java8.stream;

import com.chance.basis.entity.Person;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 操作数据集合
 * <p>
 *
 * @author chance
 * @since 2020-06-06
 */
public class StreamExample {

    /**
     * 使用Stream处理数据集合
     */
    public static void java8Stream(List<Person> persons) {
        List<String> lowWeightPersonName =
                persons.stream()
                        .filter(p -> p.getWeigth() < 70)    // 过滤器：选出体重低于70kg的人员
//                        .sorted(Comparator.comparing(Person::getWeigth))   // 按照体重排序
                        .map(p -> p.getName())   // 提取人员名称
                        .limit(2)   // 只选头2个
                        .collect(Collectors.toList()); // 将所有名称保存在List中

        System.out.println(lowWeightPersonName);
    }

    public static void java8Stream2(List<Person> persons) {
        List<String> lowWeightPersonName =
                persons.stream()
                        .filter(p -> p.getWeigth() < 70)
                        .map(Person::getName)
                        .distinct()
                        .collect(Collectors.toList());

        System.out.println(lowWeightPersonName);
    }

    /**
     * 使用Stream处理数据集合
     */
    public static void java8ParallelStream(List<Person> persons) {
        List<String> lowWeightPersonName =
                persons.parallelStream()
                        .filter(p -> p.getWeigth() < 70)    // 过滤器：选出体重低于70kg的人员
                        .sorted(Comparator.comparing(Person::getWeigth))   // 按照体重排序
                        .map(Person::getName)   // 提取人员名称
                        .collect(Collectors.toList()); // 将所有名称保存在List中

        System.out.println(lowWeightPersonName);
    }

    /**
     * Java 7 处理数据集合
     */
    public static void java7(List<Person> persons) {
        // 1.用累加器筛选元素
        List<Person> lowWeight = new ArrayList<>();
        for (Person p : persons) {
            if (p.getWeigth() < 70) {
                lowWeight.add(p);
            }
        }

        // 2.用匿名类对人员按体重进行排序
        Collections.sort(lowWeight, Comparator.comparingDouble(Person::getWeigth));

        // 3.处理排序后的人员列表
        List<String> lowWeightPersonName = new ArrayList<>();
        for (Person p : lowWeight) {
            lowWeightPersonName.add(p.getName());
        }

        System.out.println(lowWeightPersonName);
    }

    public static void main(String[] args) {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person("b", 60));
        persons.add(new Person("b", 60));
        persons.add(new Person("a", 55));
        persons.add(new Person("d", 70));
        persons.add(new Person("c", 65));
        persons.add(new Person("e", 80));
        persons.add(new Person("e", 75));
//        java7(persons);
        java8Stream2(persons);
//        java8ParallelStream(persons);
//        java8Stream2(persons);
    }
}