package com.chance.designpatterns.patterns.iterator;

import java.util.Iterator;

/**
 * @Description: 书架类
 * @Author: chance
 * @Date: 1/3/21 11:52 PM
 * @Version 1.0
 */
public class BookShelf implements Aggregate<Book> {

    private Book[] books;

    private int last = 0;

    public BookShelf(int maxSize) {
        this.books = new Book[maxSize];
    }

    /**
     * 获得书籍
     */
    public Book getBookAt(int index) {
        return books[index];
    }

    /**
     * 添加书籍
     */
    public void appendBook(Book book) {
        this.books[last] = book;
        last++;
    }

    /**
     * 获得书架上的书籍数量
     */
    public int getLength() {
        return books.length;
    }

    /**
     * 获得书架迭代器对象
     */
    @Override
    public Iterator iterator() {
        return new BookShelfIterator<Book>(this);
    }
}
