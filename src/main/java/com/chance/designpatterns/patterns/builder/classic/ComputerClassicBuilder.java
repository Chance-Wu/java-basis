package com.chance.designpatterns.patterns.builder.classic;

/**
 * 抽象构建者类
 * @author: chance
 * @date: 2022/9/1 20:42
 * @since: 1.0
 */
public abstract class ComputerClassicBuilder {

    public abstract void setUsbCount();
    public abstract void setKeyboard();
    public abstract void setDisplay();

    public abstract ComputerClassic getComputer();
}
