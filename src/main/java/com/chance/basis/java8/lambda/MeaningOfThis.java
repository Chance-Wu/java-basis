package com.chance.basis.java8.lambda;

/**
 * <p>
 * 匿名类谜题
 *     执行下面代码会有什么样的输出。
 * <p>
 *
 * @author chance
 * @since 2020-02-12
 */
public class MeaningOfThis {
    public final int value = 4;

    public void doIt() {
        int value = 6;
        Runnable r = new Runnable() {
            public final int value = 5;
            @Override
            public void run() {
                int value = 10;
                System.out.println(this.value);
            }
        };
        r.run();
    }

    public static void main(String... args) {
        MeaningOfThis m = new MeaningOfThis();
        m.doIt();
    }
}