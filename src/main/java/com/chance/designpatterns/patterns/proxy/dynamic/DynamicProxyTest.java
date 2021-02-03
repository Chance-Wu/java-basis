package com.chance.designpatterns.patterns.proxy.dynamic;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import org.junit.Test;

import java.lang.reflect.Method;

/**
 * @Description: ProxyTest
 * @Author: chance
 * @Date: 2020-09-23 09:47
 * @Version 1.0
 */
public class DynamicProxyTest {

    @Test
    public void testCglibDynamicProxy() {
        // 创建目标对象
        RealImage target = new RealImage("test.jpg");
        // 使用CGLIB创建代理对象
        RealImage proxy = (RealImage) Enhancer.create(target.getClass(),
                new MethodInterceptor() {
                    @Override
                    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
                        if ("display".equals(method.getName())) {
                            System.out.println("--------->增强处理");
                        }
                        Object result = method.invoke(target, args);
                        return result;
                    }
                });

        // 调用代理对象，执行对应方法
        proxy.display();
//        proxy.ignore();
    }

}
