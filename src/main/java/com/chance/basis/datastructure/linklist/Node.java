package com.chance.basis.datastructure.linklist;

/**
 * <p>
 * 单链表结点
 * <p>
 * 结点 = 数据域（存储数据元素） + 指针域（指向下一个具有相同结构的结点）
 *
 * <p>
 *
 * @author chance
 * @since 2020-07-04
 */
public class Node<T> {

    /**
     * 数据
     */
    public T data;

    /**
     * 下一个节点
     */
    public Node<T> next;

    public Node(T data, Node<T> next) {
        this.data = data;
        this.next = next;
    }
}
