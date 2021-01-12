package com.chance.basis.collection.list.list2array;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: List2ArrayTest
 * @Author: chance
 * @Date: 1/4/21 1:44 PM
 * @Version 1.0
 */
public class List2ArrayTest {

    @Test
    public void test1() {
        List<String> strList = new ArrayList<>();
        strList.add("aa");
        strList.add("bb");
        int size = strList.size();
        String[] strs = strList.toArray(new String[size]);
    }

    @Test
    public void test2() {
        List<String> strList = new ArrayList<>();
        strList.add("aa");
        strList.add("bb");
        String[] strs = new String[strList.size()];
    }
}
