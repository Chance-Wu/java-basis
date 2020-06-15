package com.chance.basis.entity;

/**
 * <p>
 *
 * <p>
 *
 * @author chance
 * @since 2020-01-16
 */
public class Person {

    private String name;

    private int weight;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getWeigth() {
        return weight;
    }

    public void setWeigth(int weigth) {
        this.weight = weigth;
    }

    public Person(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "{" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                '}';
    }

    /**
     * 重写equals方法
     *
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }

        //如果是同一个对象返回true，反之返回false
        if (this == o) {
            return true;
        }

        //判断是否类型相同
        if (this.getClass() != o.getClass()) {
            return false;
        }
        Person person = (Person) o;
        return name.equals(person.name) && weight == person.weight;
    }

    /**
     * 重写hashCode方法
     */
    @Override
    public int hashCode() {
        int nameHash = name.toUpperCase().hashCode();
        //maneHash和weight按位异或运算
        return nameHash ^ weight;
    }

    public static boolean isFat(Person person) {
        if (person.getWeigth() > 70) {
            return true;
        }
        return false;
    }
}
