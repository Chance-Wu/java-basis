package com.chance.basis.clazz;

import com.chance.basis.entity.Person;

/**
 * <p>
 * 获取类类型的3种方式：
 *
 *
 * <p>
 *
 * @author chance
 * @since 2020-09-09
 */
public class ClassObjectTest {

    public static void main(String[] args) {
        // 1.通过 类名.class方式创建一个Class类的对象。
        Class<Person> personClass1 = Person.class;

        // 2.通过该类的实例对象的getClass()方法获取Class类的实例对象
        Person person = new Person();
        Class<? extends Person> personClass2 = person.getClass();

        // 3.通过forName("全限定类名")创建Student类的类类型
        Class personClass3 = null;
        Person person3 = null;
        try {
            personClass3 = Class.forName("com.chance.basis.entity.Person");
            person3 = (Person) personClass3.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(personClass1 == personClass2);
        System.out.println(personClass1 == personClass3);

        System.out.println(person);
        System.out.println(person3);
    }
}
