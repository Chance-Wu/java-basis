package com.chance.basis.list;

import javax.management.ListenerNotFoundException;
import java.util.*;
import java.util.stream.Collectors;

/**
 * <p>
 * List集合去除重复数据的六种方法
 * <p>
 *
 * @author chance
 * @since 2020-06-06
 */
public class RemoveDuplicateData {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
//        List removeDuplicate1 = removeDuplicate1(list);
//        System.out.println(removeDuplicate1);
//
//        List removeDuplicate2 = removeDuplicate2(list);
//        System.out.println(removeDuplicate2);
//
//        List removeDuplicate3 = removeDuplicate3(list);
//        System.out.println(removeDuplicate3);

        List removeDuplicate6 = removeDuplicate6(list);
        System.out.println(removeDuplicate6);
    }

    /**
     * 1.循环list中的所有元素然后删除重复
     */
    public static List removeDuplicate1(List list) {
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = list.size() - 1; j > i; j--) {
                if (list.get(j).equals(list.get(i))) {
                    list.remove(j);
                }
            }
        }
        return list;
    }

    /**
     * 2.通过HashSet剔除重复元素
     */
    public static List removeDuplicate2(List list) {
        HashSet hashSet = new HashSet(list);
        list.clear();
        list.addAll(hashSet);
        return list;
    }

    /**
     * 3.删除ArrayList中重复元素，保持顺序
     */
    public static List removeDuplicate3(List list) {
        Set set = new HashSet();
        List arrayList = new ArrayList();
        Iterator iterator = list.iterator();
        if (iterator.hasNext()) {
            Object element = iterator.next();
            if (set.add(element)) {
                arrayList.add(element);
            }
        }
        list.clear();
        list.addAll(arrayList);
        return list;
    }

    /**
     * 把list里的对象遍历一遍，用list.contains()，如果不存在就放入到另外一个list集合中
     */
    public static List removeDuplicate4(List list) {
        List listTemp = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            if (!listTemp.contains(list.get(i))) {
                listTemp.add(list.get(i));
            }
        }
        return listTemp;
    }

    /**
     * 5.retailAll、removeAll用法
     */
    public static void removeDuplicate5() {
        List<String> a = Arrays.asList("a", "f", "e", "x", "w");
        List<String> b = Arrays.asList("a", "b", "c", "d");
        List<String> c = null;
        List<String> d = null;
        c = new ArrayList(a);
        c.retainAll(b); // 得到  a, b 的交集。
        d = new ArrayList(a);
        d.addAll(b); // 合并 a, b 值到 d 中。
        d.removeAll(c);// 去掉交集 c 中的所有条目。留下只出现在a 或 b 中的条目。
        System.out.println(d);
    }

    /**
     * JDK 1.8 Stream中对List进行去重
     * list.stream.distinct();
     */
    public static List removeDuplicate6(List<String> list) {
        List unique = list.stream()
//                .distinct()
//                .limit(2)
//                .skip(2)
                .map(String::length)
                .collect(Collectors.toList());
        return unique;
    }
}
