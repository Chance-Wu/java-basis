package com.chance.basis.collection.set;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashSet;

/**
 * @Description: TestHashSet
 * @Author: chance
 * @Date: 1/8/21 2:14 PM
 * @Version 1.0
 */
public class TestHashSet {

    public static void main(String[] args) {
        String[] arr = new String[]{"i", "think", "i", "am", "the", "best"};
        Collection<String> noDups = new LinkedHashSet<>(Arrays.asList(arr));
        System.out.println("(LinkedHashSet) distinct words:    " + noDups);

        Collection<String> noDups1 = new HashSet<>(Arrays.asList(arr));
        System.out.println("(HashSet) distinct words:    " + noDups1);
    }
}
