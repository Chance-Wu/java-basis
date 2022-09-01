package com.chance.designpatterns.patterns.builder.classic;

/**
 * 实体构建者类
 *
 * @author: chance
 * @date: 2022/9/1 20:47
 * @since: 1.0
 */
public class MacComputerClassicBuilder extends ComputerClassicBuilder {

    private ComputerClassic computerClassic;

    public MacComputerClassicBuilder(String cpu, String ram) {
        computerClassic = new ComputerClassic(cpu, ram);
    }

    @Override
    public void setUsbCount() {
        computerClassic.setUsbCount(2);
    }

    @Override
    public void setKeyboard() {
        computerClassic.setKeyboard("苹果键盘");
    }

    @Override
    public void setDisplay() {
        computerClassic.setDisplay("苹果显示器");
    }

    @Override
    public ComputerClassic getComputer() {
        return computerClassic;
    }
}
