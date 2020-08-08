package com.chance.basis.principles;

/**
 * <p>
 * 里式替换原则——LSP
 * <p>
 *
 * @author chance
 * @since 2020-07-17
 */
public class LSPTest {

    /**
     * 定义：所有引用基类的地方必须能够透明地使用其子类的对象
     *      即子类可以去扩展父类的功能，但是不能改变父类原有的功能
     *
     * 里氏替换原则之所以这样要求是因为继承有很多缺点，他虽然是复用代码的一种方法，但同时继承在一定程度上违反了封装。父类的属性和方法对子类都是透明的，子类可以随意修改父类的成员。这也导致了，如果需求变更，子类对父类的方法进行一些复写的时候，其他的子类无法正常工作。所以里氏替换法则被提出来。
     *
     * 确保程序遵循里氏替换原则可以要求我们的程序建立抽象，通过抽象去建立规范，然后用实现去扩展细节，这个是不是很耳熟，对，里氏替换原则和开闭原则往往是相互依存的。
     */
}