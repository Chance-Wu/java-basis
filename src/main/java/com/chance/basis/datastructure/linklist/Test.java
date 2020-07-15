package com.chance.basis.datastructure.linklist;

/**
 * <p>
 *
 * <p>
 *
 * @author chance
 * @since 2020-07-06
 */
public class Test {

    public static void main(String[] args) {
        MySingleLinkList<Object> singleLinkList = new MySingleLinkList<>();
        boolean b = singleLinkList.initList();
        singleLinkList.add("object");
        int length = singleLinkList.length();
        Object obj = singleLinkList.get(0);
        System.out.println(length);
        System.out.println(obj);
    }
}
