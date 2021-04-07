package com.chance.designpatterns.patterns.proxy.dynamic;

import com.chance.designpatterns.patterns.proxy.Image;
import com.chance.designpatterns.patterns.proxy.RealImage;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
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
public class DynamicProxyTest {

    @Test
    public void testJdkDynamicProxy() {
        // 创建目标对象
        RealImage target = new RealImage("test.jpg");
        // 动态生成一个代理对象
        // 注意使用接口类型接收
        Image proxy = (Image) Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        if ("display".equals(method.getName())) {
                            System.out.println("--------->增强处理");
                        }
                        Object result = method.invoke(target, args);
                        return result;
                    }
                });
        proxy.ignore();
    }

    @Test
    public void testCglibDynamicProxy() {
        // 创建目标对象
        RealImage2 target = new RealImage2("test.jpg");
        // 使用CGLIB创建代理对象
        // 使用父类的引用接收
        RealImage2 proxy = (RealImage2) Enhancer.create(target.getClass(),
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
