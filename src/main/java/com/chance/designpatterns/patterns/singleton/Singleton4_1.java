package com.chance.designpatterns.patterns.singleton;

/**
 * <p>
 *
 * <p>
 *
 * @author chance
 * @since 2020-01-14
 */
public enum Singleton4_1 {

    /**
     *
     */
    SINGLETON("枚举是最简单的单例模式，但不是最易读的模式") {
        @Override
        public void testAbsMethod() {
            print();
            System.out.println("枚举很难看，但是灵活多变");
        }
    };

    private String comment = null;

    Singleton4_1(String comment) {
        this.comment = comment;
    }

    public void print() {
        System.out.println("comment=" + comment);
    }

    abstract public void testAbsMethod();

    public static Singleton4_1 getInstance() {
        return SINGLETON;
    }
}
