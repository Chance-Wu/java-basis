package com.chance.reflection;

import java.lang.reflect.Method;
import java.util.ArrayList;

/**
 * @Description: 通过反射越过泛型检查
 * @Author: chance
 * @Date: 2020-10-29 14:24
 * @Version 1.0
 */
public class OverridGenericChecks {

    public static void main(String[] args) {
        ArrayList<String> strList = new ArrayList<>();
        strList.add("aaa");
        strList.add("bbb");
        //	strList.add(100);

        //获取ArrayList的Class对象，反向的调用add()方法，添加数据
        Class listClass = strList.getClass();
        try {
            Method method = listClass.getMethod("add", Object.class);
            method.invoke(strList, 100);
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (Object obj : strList) {
            System.out.println(obj);
        }
    }
}
