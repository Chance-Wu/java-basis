package com.chance.designpatterns.patterns.factory.abstractstore;

/**
 * <p>
 *
 * <p>
 *
 * @author chance
 * @since 2020-09-16
 */
public class JavaArticle extends Article {
    @Override
    public void produce() {
        System.out.println("编写Java课程笔记");
    }
}
