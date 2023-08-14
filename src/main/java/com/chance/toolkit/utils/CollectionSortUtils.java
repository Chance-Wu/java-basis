package com.chance.toolkit.utils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @description: CollectionSort
 * @author: chance
 * @date: 2022/10/17 15:31
 * @since: 1.0
 */
public class CollectionSortUtils {

    public static void main(String[] args) {
        List<Sku> list = new ArrayList<>();
        Sku sku1 = new Sku("1", new BigDecimal(100.00));
        Sku sku2 = new Sku("2", new BigDecimal(100.00));
        Sku sku3 = new Sku("3", new BigDecimal(100.00));
        list.add(sku2);
        list.add(sku1);
        list.add(sku3);
        ListUtils.sort(list, false, "price");
        System.out.println(list);
    }
}
