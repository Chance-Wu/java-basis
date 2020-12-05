package com.chance.basis.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <p>
 * Collections工具类的常用方法
 * <p>
 *
 * @author chance
 * @since 2020-07-16
 */
public class CollectionsTest {

    public static void main(String[] args) {
        ArrayList<Object> arrayList = new ArrayList<>();
        arrayList.add("1");
        arrayList.add("2");
        // 为list创建一个可读集合
        List<Object> list = Collections.unmodifiableList(arrayList);
        list.remove(0);
        System.out.println(arrayList);
    }

}
