package com.chance.thread.communicate.poll;

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

    private List<String> list = new ArrayList<>();

    private volatile int size = list.size();

    public void add() {
        list.add("elements");
    }

    public int getSize() {
        return size;
    }
}
