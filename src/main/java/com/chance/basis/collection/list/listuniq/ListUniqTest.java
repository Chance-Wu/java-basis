package com.chance.basis.collection.list.listuniq;

import org.junit.Test;

import java.util.*;

/**
 * @Description: List 去重的6种方法
 * @Author: chance
 * @Date: 1/4/21 10:05 AM
 * @Version 1.0
 */
public class ListUniqTest {

    /**
     * 双循环去重
     */
    @Test
    public void doubleLoop() {
        String[] array = {"a", "b", "c", "c", "d", "e", "e", "e", "a"};
        List<String> result = new ArrayList<>();
        boolean flag;
        // 循环原数组
        for (int i = 0; i < array.length; i++) {
            flag = false;
            // 循环结果集
            for (int j = 0; j < result.size(); j++) {
                if (array[i].equals(result.get(j))) {
                    flag = true;
                    break;
                }
            }
            // 数组的元素和结果集中的元素进行比对，若不相同，则存入结果集
            if (!flag) {
                result.add(array[i]);
            }
        }
        String[] arrayResult = result.toArray(new String[result.size()]);
        System.out.println(Arrays.toString(arrayResult));
    }

    /**
     * 使用indexOf进行判断结果集中是否存在了数组元素去重
     */
    @Test
    public void indexOf() {
        String[] array = {"a", "b", "c", "c", "d", "e", "e", "e", "a"};
        List<String> list = new ArrayList<>();
        list.add(array[0]);
        for (int i = 1; i < array.length; i++) {
            if (list.toString().indexOf(array[i]) == -1) {
                list.add(array[i]);
            }
        }
        String[] arrayResult = list.toArray(new String[list.size()]);
        System.out.println(Arrays.toString(arrayResult));
    }

    /**
     * 嵌套循环去重
     */
    @Test
    public void nestedLoop() {
        String[] array = {"a", "b", "c", "c", "d", "e", "e", "e", "a"};
        List<String> list = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] == array[j]) {
                    j = ++i;
                }
            }
            list.add(array[i]);
        }
        String[] arrayResult = list.toArray(new String[list.size()]);
        System.out.println(Arrays.toString(arrayResult));
    }

    /**
     * sort排序，相邻比较去重
     */
    @Test
    public void sort() {
        String[] array = {"a", "b", "c", "c", "d", "e", "e", "e", "a"};
        // 将数组按升序排序
        Arrays.sort(array);
        List<String> list = new ArrayList<>();
        list.add(array[0]);
        for (int i = 1; i < array.length; i++) {
            if (!array[i].equals(list.get(list.size() - 1))) {
                list.add(array[i]);
            }
        }
        String[] arrayResult = list.toArray(new String[list.size()]);
        System.out.println(Arrays.toString(arrayResult));
    }

    /**
     * set方法无序排列去重
     */
    @Test
    public void set() {
        String[] array = {"a", "b", "c", "c", "d", "e", "e", "e", "a"};
        Set<String> set = new HashSet<>();
        // 遍历原数组，将元素添加进Set中
        for (int i = 0; i < array.length; i++) {
            set.add(array[i]);
        }
        String[] arrayResult = set.toArray(new String[set.size()]);
        System.out.println(Arrays.toString(arrayResult));
    }

    /**
     * 利用Iterator遍历，remove方法移除去重
     */
    @Test
    public void remove() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(4);
        list.add(1);
        list.add(2);
        list.add(5);
        list.add(1);
        List<Integer> listTemp = new ArrayList<>();
        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            int a = it.next();
            // 如果临时结果集里包含了该元素，则移除list中的该元素
            if (listTemp.contains(a)) {
                it.remove();
            } else {
                listTemp.add(a);
            }
        }
        for (Integer i : list) {
            System.out.println(i);
        }
    }
}
