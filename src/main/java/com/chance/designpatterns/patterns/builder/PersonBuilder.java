package com.chance.designpatterns.patterns.builder;

/**
 * <p>
 * Builder
 * 构建器模式
 * <p>
 *
 * @author chance
 * @since 2020-06-09
 */
public class PersonBuilder {

    //必要参数

    private final int id;
    private final String name;

    //可选参数

    private int age;
    private String sex;
    private String phone;
    private String address;
    private String desc;

    @Override
    public String toString() {
        return "PersonBuilder{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }

    private PersonBuilder(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.age = builder.age;
        this.sex = builder.sex;
        this.phone = builder.phone;
        this.address = builder.address;
        this.desc = builder.desc;
    }

    /**
     * 静态内部类
     */
    public static class Builder {
        //必要参数
        private final int id;
        private final String name;
        //可选参数
        private int age;
        private String sex;
        private String phone;
        private String address;
        private String desc;

        public Builder(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public Builder age(int val) {
            this.age = val;
            return this;
        }

        public Builder sex(String val) {
            this.sex = val;
            return this;
        }

        public Builder phone(String val) {
            this.phone = val;
            return this;
        }

        public Builder address(String val) {
            this.address = val;
            return this;
        }

        public Builder desc(String val) {
            this.desc = val;
            return this;
        }

        public PersonBuilder build() {
            return new PersonBuilder(this);
        }
    }
}
