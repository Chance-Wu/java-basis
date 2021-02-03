package com.chance.designpatterns.patterns.proxy;

import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Description: ProxyTest
 * @Author: chance
 * @Date: 2020-09-23 09:47
 * @Version 1.0
 */
public class ProxyTest {

    /**
     * 静态代理
     */
    @Test
    public void testStaticProxy() {
        Image image = new ProxyImage("test.jpg");
        // 图像将从磁盘加载
        image.display();
        System.out.println("==========");
        // 图像不需要从磁盘加载
        image.display();
    }

    @Test
    public void testJdkDynamicProxy() {
        // 准备一个target
        RealImage target = new RealImage("test.jpg");
        // 动态生成一个代理对象
        // 注意使用接口类型接收
        Image proxy = (Image) Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new InvocationHandler() {
                    /**
                     * 增强
                     * @param proxy
                     * @param method
                     * @param args
                     * @return
                     * @throws Throwable
                     */
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        if ("display".equals(method.getName())) {
                            System.out.println("--------->增强处理");
                        }
                        Object result = method.invoke(target, args);
                        return result;
                    }
                });

        // 调用代理对象，执行对应方法
//        proxy.display();
        proxy.ignore();
    }

    @Test
    public void testCglibDynamicProxy() {

    }
}
