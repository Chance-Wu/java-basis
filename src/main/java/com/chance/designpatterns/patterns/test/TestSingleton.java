package com.chance.designpatterns.patterns.test;

import com.chance.designpatterns.patterns.entity.User;
import com.chance.designpatterns.patterns.singleton.Singleton1;

/**
 * <p>
 *
 * <p>
 *
 * @author chance
 * @since 2020-06-17
 */
public class TestSingleton {

    public static void main(String[] args) {
        Singleton1 instance1 = Singleton1.getInstance();
        Singleton1 instance2 = Singleton1.getInstance();
        System.out.println(instance1);
        System.out.println(instance2);

        User user1 = new User();
        User user2 = new User();
        System.out.println(user1);
        System.out.println(user2);


    }
}
