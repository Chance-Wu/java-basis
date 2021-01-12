package com.chance.designpatterns.patterns.iterator;

import java.util.Iterator;

/**
 * @Description: Test
 * @Author: chance
 * @Date: 1/4/21 12:24 AM
 * @Version 1.0
 */
public class Test {

    public static void main(String[] args) {
        //创建一个书架
        BookShelf bookShelf = new BookShelf(5);
        //向书架中添加书籍
        bookShelf.appendBook(new Book("深入理解Java虚拟机"));
        bookShelf.appendBook(new Book("Java编程思想"));
        bookShelf.appendBook(new Book("高性能MySQL"));
        bookShelf.appendBook(new Book("Effective Java 中文版"));
        bookShelf.appendBook(new Book("数据结构与算法分析Java语言描述"));
        //获得书架迭代器
        Iterator iterator = bookShelf.iterator();
        //迭代
        while (iterator.hasNext()) {
            Book book = (Book) iterator.next();
            System.out.println(book.getName());
        }
    }
}
