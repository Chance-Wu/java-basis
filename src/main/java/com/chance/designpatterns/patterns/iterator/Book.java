package com.chance.designpatterns.patterns.iterator;

/**
 * @Description: 书籍类
 * @Author: chance
 * @Date: 1/3/21 11:50 PM
 * @Version 1.0
 */
public class Book {

    /**
     * 书籍名称
     */
    private String name;

    public Book(String name) {
        this.name = name;
    }

    /**
     * 获得书籍名称
     */
    public String getName() {
        return name;
    }
}
