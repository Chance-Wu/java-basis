package com.chance.basis.introspector;

import org.apache.commons.beanutils.BeanUtils;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;

/**
 * @Description: Test
 * @Author: chance
 * @Date: 2022/1/18 2:48 下午
 * @Version 1.0
 */
public class Test {

    public static void main(String[] args) throws Exception {
        // 不自省从父类继承的属性
        BeanInfo beanInfo = Introspector.getBeanInfo(Person.class, Object.class);
        // 取得属性描述器
        PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
        for (PropertyDescriptor propertyDescriptor: propertyDescriptors) {
            System.out.println(propertyDescriptor.getName());
        }

        /**
         * 操纵bean的指定属性：age
         */
        Person person = new Person();
        PropertyDescriptor pd = new PropertyDescriptor("age", Person.class);
        // 得到属性的写方法
        Method writeMethod = pd.getWriteMethod();
        writeMethod.invoke(person,24);
        // 得到属性的读方法
        Method readMethod = pd.getReadMethod();
        Object age = readMethod.invoke(person, null);
        System.out.println(age);

        Person p = new Person();

        PropertyDescriptor pd1 = new PropertyDescriptor("ab", Person.class);
        System.out.println(pd1.getPropertyType());
    }
}
