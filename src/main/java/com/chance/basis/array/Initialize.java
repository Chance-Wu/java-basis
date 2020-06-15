package com.chance.basis.array;

/**
 * <p>
 *
 * <p>
 *
 * @author chance
 * @since 2019-11-03
 */
public class Initialize {

    public static void main(String[] args) {
        String[] s1 = {"wuchenyang", "nino", "chance"};
        String[] s2;
        int[] s3 = new int[10];
        String[] s4=new String[10];
        s2 = s1;
        System.out.println(s1);
        System.out.println(s2);
        // 基本类型会初始化为空，对于数值，空值就是零；对于char，它是null；而对于boolean，它却是false。
        System.out.println(s3[0]);  //0
        System.out.println(s4[0]);  //null

        System.out.println(s1.length);

        System.out.println(s1==s2);
        System.out.println(s2.equals(s1));
        System.out.println(s1[3]);
    }

}
