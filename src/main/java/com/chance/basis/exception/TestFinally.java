package com.chance.basis.exception;

/**
 * <p>
 *
 * <p>
 *
 * @author chance
 * @since 2020-02-23
 */
public class TestFinally {

    public static void main(String[] args) {
        System.out.println(method1());
        System.out.println(method2());
        System.out.println(method3());
    }

    public static int method1() {
        int k;
        try {
            k = 1;
            //返回的k=1首先存储到栈中的返回值位置，如果顺利完成就把该位置的值返回，如果遇到特殊指令如break、continue、return、抛异常就清除
            return k;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //清除原来的返回值，把100放到返回值的位置上，如果顺利结束就返回，否则清除
            return 100;
        }
    }

    public static int method2() {
        int k = 1;
        while (true) {
            try {
                return k;
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                //遇到break，返回值位置的值被清除
                break;
            }
        }
        k = 100;
        return k;
    }

    public static int method3() {
        int k = 1;
        //此处抛异常或者try和catch里调用system.exit()方法finally就不会执行。
        Integer.parseInt(null);
        try {
            return k;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return k;
        }
    }
}
