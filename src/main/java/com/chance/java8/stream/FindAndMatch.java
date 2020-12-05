package com.chance.java8.stream;

import com.chance.basis.entity.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * <p>
 * 查找和匹配
 * <p>
 * allMatch、anyMatch、noneMatch、findFirst和findAny
 * <p>
 *
 * @author chance
 * @since 2020-06-08
 */
public class FindAndMatch {

    public static void findAny(List<Person> list) {
        Optional<Person> person = list.stream()
                .filter(Person::isFat)
                .findAny();

        System.out.println(person);
        System.out.println(person.isPresent());
    }

    public static boolean anyMatch(List<Person> list) {
        if (list.stream().anyMatch(Person::isFat)) {
            System.out.println("The people is fat!");
            return true;
        }
        return false;
    }

    public static boolean allMatch(List<Person> list) {
        boolean isHealthy = list.stream().anyMatch(p -> p.getWeigth() <= 80);
        System.out.println("People are healthy!");
        return isHealthy;
    }

    public static void main(String[] args) {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person("b", 60));
        persons.add(new Person("b", 60));
        persons.add(new Person("a", 55));
        persons.add(new Person("d", 70));
        persons.add(new Person("c", 65));
//        persons.add(new Person("e", 80));
//        persons.add(new Person("e", 75));
//        anyMatch(persons);
//        allMatch(persons);
        findAny(persons);
    }
}
