package com.chance.basis.thread.communicate.waitnotify;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *
 * <p>
 *
 * @author chance
 * @since 2020-07-01
 */
public class MyList {

    private static List<String> list = new ArrayList<>();

    public static void add() {
        list.add("anyString");
    }

    public static int size() {
        return list.size();
    }
}
