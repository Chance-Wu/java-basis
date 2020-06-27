package com.chance.basis.collection.map;

import java.util.HashMap;

/**
 * <p>
 *
 * <p>
 *
 * @author chance
 * @since 2020-06-27
 */
public class TestEqualsAndHashCode {

    private static class Person {
        int idCard;
        String name;

        public Person(int idCard, String name) {
            this.idCard = idCard;
            this.name = name;
        }

        /**
         * 重写equals方法
         *
         * @param obj
         * @return
         */
        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            Person person = (Person) obj;
            // 两个对象是否等值，通过idCard来确定
            return this.idCard == person.idCard;
        }
    }

    public static void main(String[] args) {
        HashMap<Person, String> map = new HashMap<>(16);
        Person person = new Person(1234, "chance");

        map.put(person, "chance");

        //get取出，从逻辑上讲应该能输出“chance”
        System.out.println("结果:" + map.get(new Person(1234, "wcy")));
    }
}
