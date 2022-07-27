package com.chance.basis.annotation;

import org.junit.Test;

import java.lang.reflect.Method;

/**
 * <p>
 *
 * <p>
 *
 * @author chance
 * @since 2020-09-03
 */
public class AnnotationTest {

    @Test
    @CustomAnnotation(name = "chance", id = 1)
    public void test() {

        Class<AnnotationTest> clazz = AnnotationTest.class;
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            CustomAnnotation customAnnotation = method.getAnnotation(CustomAnnotation.class);
            if (customAnnotation != null) {
                System.out.println("annotation: " + "name------>" + customAnnotation.name() + "------>id------>" + customAnnotation.id());
            }
        }
    }

    @Test
    @Hello("hello")
    public void testAnnotation() throws NoSuchMethodException {

        Class cls = AnnotationTest.class;
        Method method = cls.getMethod("testAnnotation");
        Hello hello = method.getAnnotation(Hello.class);
        System.out.println(hello);
    }

    /**
     * @see #testAnnotation()
     * 该注解注解@see可以在注释中实现链接跳转。@see可以指向包,类,方法,属性.
     * <p>
     * 一个完整的使用方法是这样的@see package.class#member.
     */
    @Test
    public void testSee() {

    }

    @Test
    public void testDemo() {

    }
}
