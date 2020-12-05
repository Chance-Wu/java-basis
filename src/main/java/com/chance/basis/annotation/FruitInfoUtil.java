package com.chance.basis.annotation;

import java.lang.reflect.Field;

/**
 * @Description: FruitInfoUtil
 * @Author: chance
 * @Date: 2020-10-30 16:59
 * @Version 1.0
 */
public class FruitInfoUtil {

    public static void getFruitInfo(Class<?> clazz) {
        String strFruitProvider = "供应商信息";

        //通过反射获取处理注解
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            // 判断FruitProvider注解是否在该属性字段上
            if (field.isAnnotationPresent(FruitProvider.class)) {
                FruitProvider fruitProvider = field.getAnnotation(FruitProvider.class);
                //注解信息的处理地方
                strFruitProvider = " 供应商编号：" + fruitProvider.id()
                        + " 供应商名称：" + fruitProvider.name()
                        + " 供应商地址：" + fruitProvider.address();
                System.out.println(strFruitProvider);
            }
        }
    }
}
