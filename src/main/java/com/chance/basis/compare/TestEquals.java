package com.chance.basis.compare;

import com.chance.basis.entity.Person;

import java.util.HashSet;

/**
 * <p>
 * 比较equals() 返回true以及false时，hashCode()的值
 * <p>
 *
 * @author chance
 * @since 2020-01-16
 */
public class TestEquals {

    public static void main(String[] args) {
        //新建2个相同内容的Person对象，
        //再用两个equals比较它们是否相等。

        Person p1 = new Person("eee", 100);
        Person p2 = new Person("eee", 100);
        Person p3 = new Person("aaa", 200);

        System.out.printf("p1.equals(p2) : %s; p1(%d) p2(%d)\n", p1.equals(p2), p1.hashCode(), p2.hashCode());
        System.out.printf("p1.equals(p3) : %s; p1(%d) p3(%d)\n", p1.equals(p3), p1.hashCode(), p3.hashCode());

        HashSet<Person> personSet = new HashSet<>();
        personSet.add(p1);
        personSet.add(p2);
        personSet.add(p3);

        //比较p1和p2
        System.out.printf("p1.equals(p2) : %s; p1(%d) p2(%d)\n", p1.equals(p2), p1.hashCode(), p2.hashCode());
        System.out.printf("p1.equals(p3) : %s; p1(%d) p3(%d)\n", p1.equals(p3), p1.hashCode(), p3.hashCode());
        //打印set
        System.out.printf("set:%s\n", personSet);

    }
}
