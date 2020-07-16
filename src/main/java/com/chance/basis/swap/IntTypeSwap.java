package com.chance.basis.swap;

/**
 * <p>
 *
 * <p>
 *
 * @author chance
 * @since 2020-07-16
 */
public class IntTypeSwap {

    public static void main(String[] args) {

        // CODE_1
        IntType type1 = new IntType();
        type1.setValue(1);

        IntType type2 = new IntType();
        type2.setValue(2);
        // CODE_1

        swap1(type1, type2);
        System.out.printf("type1.value = %s, type2.value = %s", type1.getValue(), type2.getValue());
        swap2(type1, type2);
        System.out.println();
        System.out.printf("type1.value = %s, type2.value = %s", type1.getValue(), type2.getValue());
    }

    public static void swap2(IntType type1, IntType type2) {
        int temp = type1.getValue();
        type1.setValue(type2.getValue());
        type2.setValue(temp);
    }

    public static void swap1(IntType type1, IntType type2) {
        IntType type = type1;
        type1 = type2;
        type2 = type;
    }
}
