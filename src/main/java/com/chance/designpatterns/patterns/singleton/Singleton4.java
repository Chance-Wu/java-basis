package com.chance.designpatterns.patterns.singleton;

/**
 * <p>
 * 枚举模式
 * <p>
 * 用枚举实现单例模式，无法实现懒加载
 * <p>
 *
 * @author chance
 * @since 2020-01-14
 */
public class Singleton4 {

    private Singleton4() {
    }

    /**
     * 枚举类型是线程安全的，并且只会装载一次
     */
    private enum SingletonEnum {
        INSTANCE;

        private final Singleton4 instance;

        SingletonEnum() {
            instance = new Singleton4();
        }

        private Singleton4 getInstance() {
            return instance;
        }

    }

    public static Singleton4 getInstance() {
        return SingletonEnum.INSTANCE.getInstance();
    }
}
