package com.chance.basis.thread.communicate.poll;

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

    private List<String> list = new ArrayList<String>();

    public void add() {
        list.add("elements");
    }

    public int size() {
        return list.size();
    }

}
