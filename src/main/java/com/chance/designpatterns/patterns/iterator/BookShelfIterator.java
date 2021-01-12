package com.chance.designpatterns.patterns.iterator;

import java.util.Iterator;

/**
 * @Description: 书架迭代器
 * @Author: chance
 * @Date: 1/3/21 11:56 PM
 * @Version 1.0
 */
public class BookShelfIterator<E> implements Iterator<E> {

    private BookShelf bookShelf;
    private int index;

    public BookShelfIterator(BookShelf bookShelf) {
        this.bookShelf = bookShelf;
        this.index = 0;
    }

    /**
     * 检测是否还有下一本书
     */
    @Override
    public boolean hasNext() {
        if (index < bookShelf.getLength()) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 返回下一本书
     */
    @Override
    public E next() {
        Book book = bookShelf.getBookAt(index);
        index++;
        return (E) book;
    }
}
