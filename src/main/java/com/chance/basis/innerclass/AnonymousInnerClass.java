package com.chance.basis.innerclass;

/**
 * @Description: AnonymousInnerClass
 * @Author: chance
 * @Date: 2020-10-31 14:51
 * @Version 1.0
 */
public class AnonymousInnerClass {

    public void test(Bird bird) {
        System.out.println(bird.getName() + "能够飞 " + bird.fly() + "米");
    }

    public static void main(String[] args) {
        AnonymousInnerClass test = new AnonymousInnerClass();
        test.test(new Bird() {
            @Override
            public int fly() {
                return 10000;
            }

            @Override
            public String getName() {
                return "大雁";
            }
        });
    }
}
