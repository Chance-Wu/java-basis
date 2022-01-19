package com.chance.basis.introspector;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConversionException;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;
import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description: BeanUtilsTest
 * @Author: chance
 * @Date: 2022/1/18 3:32 下午
 * @Version 1.0
 */
public class BeanUtilsTest {

    public static void main(String[] args) throws Exception {
//        Person person = new Person();
//        BeanUtils.setProperty(person,"ab","chance");
//        System.out.println(person.getName());


        Person p = new Person();
        // 模拟用户提交的表单
        String name = "yaoer";
        String password = "123";
        String age = "24";
        String birthday = "1994-10-12";
        // 给beanUtils注册一个日期转换器
        /*ConvertUtils.register(new Converter() {
            @Override
            public Object convert(Class type, Object value) {
                if (value == null) {
                    return null;
                }
                if (!(value instanceof String)) {
                    throw new ConversionException("只支持String类型的转换！");
                }
                String str = (String) value;
                if ("".equals(str.trim())) {
                    return null;
                }

                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                try {
                    return df.parse(str);
                } catch (ParseException e) {
                    throw new RuntimeException(e); // 异常链不能断
                }
            }
        }, Date.class);*/
        ConvertUtils.register(new DateLocaleConverter(),Date.class);

        // 封装到p对象中

        BeanUtils.setProperty(p, "name", name);
        BeanUtils.setProperty(p, "password", password);
        // 自动将数据转换（基本类型）
        BeanUtils.setProperty(p, "age", age);
        BeanUtils.setProperty(p, "birthday", birthday);

        System.out.println(p.getName());
        System.out.println(p.getPassword());
        System.out.println(p.getAge());
        System.out.println(p.getBirthday());


        Map map = new HashMap();
        map.put("name","chance");
        map.put("password","1234");
        map.put("age","28");
        map.put("birthday","1994-09-19");

        ConvertUtils.register(new DateLocaleConverter(), Date.class);
        Person bean = new Person();
        BeanUtils.populate(bean, map);//用map集合中的值填充bean的属性

        System.out.println(bean.getName());
        System.out.println(bean.getPassword());
        System.out.println(bean.getAge());
        System.out.println(bean.getBirthday());
    }
}
