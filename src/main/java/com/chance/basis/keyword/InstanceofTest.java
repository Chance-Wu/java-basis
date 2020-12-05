package com.chance.basis.keyword;

import com.chance.basis.entity.Person;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *
 * <p>
 *
 * @author chance
 * @since 2020-09-14
 */
public class InstanceofTest {

    @Test
    public void test() {
        // 1.编译不通过，instanceof 运算符只能用作对象的判断
        int i = 0;
//        System.out.println(i instanceof Integer);

        // 2.如果 obj 为 null，那么将返回 false
        System.out.println(null instanceof Object);

        // 3.class类的实例对象
        Integer integer = new Integer(1);
        System.out.println(integer instanceof Integer);

        ArrayList<Object> arrayList = new ArrayList<>();
        System.out.println(arrayList instanceof List);

        Person p1 = new Person();

//        System.out.println(p1 instanceof String);//编译报错
        System.out.println(p1 instanceof List);//false
        System.out.println(p1 instanceof List<?>);//false
//        System.out.println(p1 instanceof List<Person>);//编译报错
    }
}
