package com.chance.basis.collection.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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
         * 运行程序会抛出并发修改异常
         */
//        for (String platform : platformList) {
//            if (platform.equals("博客园")) {
//                platformList.remove(platform);
//            }
//        }

        /**
         * 使用Iterator的remove()方法
         */
//        Iterator<String> iterator = platformList.iterator();
//        while (iterator.hasNext()) {
//            String platform = iterator.next();
//            if (platform.equals("博客园")) {
//                iterator.remove();
//            }
//        }

        /**
         * 使用for循环正序遍历
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
         * 使用for循环倒序遍历
         */
        for (int i = platformList.size() - 1; i >= 0; i--) {
            String item = platformList.get(i);

            if (item.equals("掘金")) {
                platformList.remove(i);
            }
        }

        System.out.println(platformList);
    }
}
