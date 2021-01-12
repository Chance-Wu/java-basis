package com.chance.basis.collection.list.sort;

/**
 * @Description: Person
 * @Author: chance
 * @Date: 1/4/21 9:59 AM
 * @Version 1.0
 */
public class Person implements Comparable<Person> {
    private String name;
    private Integer order;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    @Override
    public int compareTo(Person arg0) {
        //这里定义你排序的规则
        return this.getOrder().compareTo(arg0.getOrder());
    }
}
