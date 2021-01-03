package com.chance.basis.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Vector;

/**
 * @Description: CollectionTest
 * @Author: chance
 * @Date: 1/3/21 11:01 PM
 * @Version 1.0
 */
public class CollectionTest {

    public static void main(String[] args) {
        Collection<String> collection = new Vector<>();
        collection.add("gogogo");
        collection.add("pap");
        collection.add("niko");
        collection.add("kitty");
        collection.add("kitty");

        Collection<String> coll = new ArrayList<>();
        coll.add("niko");
        coll.add("kitty");
        coll.add("pecuyu");

        // collection.clear(); // 清空集合
        //System.out.println(collection.isEmpty()); // 集合是否为空

        // int size = collection.size(); // 获取集合大小
        // System.out.println(size);

        // boolean contains = collection.contains("niko"); // 是否包含另一个元素
        // System.out.println(contains);
        //boolean containsAll = collection.containsAll(coll); //是否完全包含另一个集合
        //System.out.println(containsAll);

        // collection.remove("kitty");   // 删除第一个匹配项，删除了匹配项则返回true
        // boolean removeAll = collection.removeAll(coll);  // 删除与指定集合有交集的部分，原集合有改变就返回true
        // System.out.println(removeAll);

        //boolean retainAll = collection.retainAll(coll);// 保留与指定集合有交集的部分，原集合有改变就返回true
        //System.out.println(retainAll);

        // iterator 迭代器， 方式1
        Iterator<String> iterator = collection.iterator();
        while(iterator.hasNext()){
            System.out.print(iterator.next()+" ");
        }
        System.out.println("\n"+"-------------------");

        // 方式2 ，for循环完iterator1就会被销毁，节约内存提高效率
        for (Iterator<String> iterator1 = collection.iterator(); iterator1.hasNext(); ) {
            System.out.print(iterator1.next()+" ");

        }
        System.out.println("\n"+"-------------------");


        Object[] array = collection.toArray();  // 转化为object数组
        for (Object string : array) {
            System.out.print(string+" ");
        }
        System.out.println("\n"+"-------------------");
        String[] arr=new String[collection.size()];
        String[] array2 = collection.toArray(arr);  // 指定要转化的数组类型
        for (String string : array2) {
            System.out.print(string+" ");
        }
    }
}
