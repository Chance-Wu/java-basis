package com.chance.designpatterns.patterns.bridge;

/**
 * <p> 扩展抽象化角色 </p>
 *
 * @author chance
 * @date 2023/8/23 14:32
 * @since 1.0
 */
public class RefinedAbstraction extends Abstraction {

    protected RefinedAbstraction(Implementor imple) {
        super(imple);
    }

    @Override
    public void operation() {
        System.out.println("扩展抽象化(Refined Abstraction)角色被访问");
        imple.operationImpl();
    }
}
