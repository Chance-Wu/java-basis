package com.chance.reflection.proxy;

import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * <p>
 *
 * <p>
 *
 * @author chance
 * @since 2020-02-20
 */
public class Client {

    public static void main(String[] args) {
        //要代理的真实对象
        RealSubject realSubject = new RealSubject();
        //要代理的哪个真实对象，就将该对象传进去，最后是通过该真实对象来调用其方法的
        DynamicProxy handler = new DynamicProxy(realSubject);

        //通过Proxy的newProxyInstance方法来创建我们的代理对象
        Subject subject = (Subject) Proxy.newProxyInstance(handler.getClass().getClassLoader(),
                realSubject.getClass().getInterfaces(), handler);
        System.out.println(subject.getClass().getName());
        System.out.println(Arrays.toString(realSubject.getClass().getInterfaces()));
        subject.rent();
        subject.hello("world");
    }
}
