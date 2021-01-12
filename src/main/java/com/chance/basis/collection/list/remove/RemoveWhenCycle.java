package com.chance.basis.collection.list.remove;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * <p>
 * List如何一边遍历一边删除
 * <p>
 *
 * @author chance
 * @since 2020-07-15
 */
public class RemoveWhenCycle {

    public static void main(String[] args) {
        List<String> platformList = new ArrayList<>();
        platformList.add("博客园");
        platformList.add("CSDN");
        platformList.add("掘金");

        /**
         * foreach循环删除 错误
         */
//        for (String platform : platformList) {
//            if (platform.equals("博客园")) {
//                platformList.remove(platform);
//            }
//        }

        /**
         * 使用Iterator的remove()方法 正确
         */
//        Iterator<String> iterator = platformList.iterator();
//        while (iterator.hasNext()) {
//            String platform = iterator.next();
//            if (platform.equals("博客园")) {
//                iterator.remove();
//            }
//        }

        /**
         * 使用for循环正序遍历 错误
         */
//        for (int i = 0; i < platformList.size(); i++) {
//            String item = platformList.get(i);
//
//            if (item.equals("博客园")) {
//                platformList.remove(i);
//                i = i - 1;
//            }
//        }

        /**
         * 使用for循环倒序遍历 正确
         */
//        for (int i = platformList.size() - 1; i >= 0; i--) {
//            String item = platformList.get(i);
//
//            if (item.equals("掘金")) {
//                platformList.remove(i);
//            }
//        }

        /**
         * 正确,拷贝一份只读副本，然后遍历的时候遍历副本，删除的时候删除原来的list。
         */
        CopyOnWriteArrayList<String> cowList = new CopyOnWriteArrayList<>(platformList);
        for (String item : cowList) {
            if (item.equals("掘金")) {
                platformList.remove(item);
            }
        }

        System.out.println(platformList);
    }
}
