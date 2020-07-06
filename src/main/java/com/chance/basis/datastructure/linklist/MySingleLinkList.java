package com.chance.basis.datastructure.linklist;

/**
 * <p>
 * 单链表
 *
 *
 * <p>
 *
 * @author chance
 * @since 2020-07-04
 */
public class MySingleLinkList<T> {

    /**
     * 首元结点
     */
    private Node<T> first;

    /**
     * 头指针
     */
    private Node<T> head;

    /**
     * 链表长度
     */
    int size;

    private final static int POINTER_INDEX = -2;

    public boolean initList() {
        size = 0;
        first = new Node<>(null, null);
        head = new Node<>(null, first);
        return true;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 获取结点
     */
    public Node<T> getNode(int index) {
        Node<T> renode = head;
        // 移动指针位置，初始位置为-2
        for (int p = POINTER_INDEX; p < index; p++) {
            renode = renode.next;
        }
        return renode;
    }

    /**
     * 在末尾添加元素
     */
    public void add(T a) {
        // 1.声明一个新结点作为新的尾结点，next = null
        Node<T> renode = new Node<>(a, null);
        // 2.获取原链表的最后一个结点，把它的next指向新结点
        getNode(size - 1).next = renode;
        // 3.长度+1
        size++;
    }

    /**
     * 删除i位置结点，并返回删掉的数据
     */
    public T remove(int index) {
        // 如果是尾结点，将前一个结点的指针域设置为null，返回尾结点的data域
        if (index == size - 1) {
            T delData = getNode(size - 1).data;
            getNode(size - 2).next = null;
            return delData;
        }

        Node<T> prev = getNode(index - 1);
        T delData = prev.next.data;
        prev.next = prev.next.next;
        size--;
        return delData;
    }

    public void insert(int i, T a) {
        Node<T> prev = getNode(i - 1);
        Node<T> renode = new Node<>(a, prev.next);
        prev.next = renode;
        size++;
    }

    public T get(int i) {
        return getNode(i).data;
    }

    /**
     * 为i位置元素重新赋值
     */
    public void set(int i, T a) {
        getNode(i).data = a;
    }

    public int length() {
        return size;
    }

    /**
     * 清空链表
     */
    public void clear() {
        initList();
    }

    public void print() {
        for (int i = 0; i < size; i++) {
            System.out.println(getNode(i).data);
        }
    }
}
