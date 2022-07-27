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
public class ProxyTest {

    public static void main(String[] args) {
        //要代理的真实对象
        RealSubject realSubject = new RealSubject();
        //要代理的哪个真实对象，就将该对象传进去，最后是通过该真实对象来调用其方法的
        DynamicProxy handler = new DynamicProxy(realSubject);

        // 把生成的代理类保存到文件
        // 在生成字节码的那个地方，也就是 ProxyGenerator.generateProxyClass() 方法里面
        //通过代码可以看到，里面是用参数 saveGeneratedFiles 来控制是否把生成的字节码保存到本地磁盘。
        System.getProperties().put("jdk.proxy.ProxyGenerator.saveGeneratedFiles", "true");

        //通过Proxy的newProxyInstance方法来创建我们的代理对象
        Subject subject = (Subject) Proxy.newProxyInstance(handler.getClass().getClassLoader(),
                realSubject.getClass().getInterfaces(), handler);
        System.out.println(subject.getClass().getName());
        System.out.println(Arrays.toString(realSubject.getClass().getInterfaces()));
        subject.rent();
        subject.hello("world");
    }
}
