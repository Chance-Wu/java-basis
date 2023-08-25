package com.chance.designpatterns.patterns.bridge;

/**
 * <p> 具体实现化角色 </p>
 *
 * @author chance
 * @date 2023/8/23 13:32
 * @since 1.0
 */
public class ConcreteImplementorA implements Implementor {
    @Override
    public void operationImpl() {
        System.out.println("具体实现化(Concrete Implementor)角色被访问");
    }
}
