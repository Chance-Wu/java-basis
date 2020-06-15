package com.chance.basis.reflection;

/**
 * <p>
 * 类型转换前先做检查
 * <p>
 *
 * @author chance
 * @since 2020-02-19
 */
public class Derived extends Base {

    public static void main(String[] args) {
        Base base = new Derived();
        //判断类型
        if (base instanceof Derived) {
            System.out.println("ok");
        } else {
            System.out.println("error");
        }
    }
}
