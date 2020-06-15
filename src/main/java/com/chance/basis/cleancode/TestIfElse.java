package com.chance.basis.cleancode;

import com.chance.basis.entity.Person;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/**
 * <p>
 *
 * <p>
 *
 * @author chance
 * @since 2020-03-16
 */
public class TestIfElse {

    public static void main(String[] args) {
        Person person = new Person("chance", 135);
        String value1 = "Jack";
        String value2 = "Lucy";
        String value3 = "Tom";

        if (person.getName().equals(value1)) {
            doAction1(value1);
        } else if (person.getName().equals(value2)) {
            doAction2(value2);
        } else if (person.getName().equals(value3)) {
            doAction3(value3);
        }

        Map<?, Function<String,?>> actionMappings = new HashMap<>(16);




    }

    private static void doAction3(String someParams) {
        System.out.println(someParams);
    }

    private static void doAction2(String someParams) {
        System.out.println(someParams);
    }

    public static void doAction1(String someParams) {
        System.out.println(someParams);
    }

}
