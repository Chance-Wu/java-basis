package com.chance.designpatterns.patterns.builder.classic;

/**
 * @author: chance
 * @date: 2022/9/1 20:54
 * @since: 1.0
 */
public class LenovoComputerClassicBuilder extends ComputerClassicBuilder {

    private ComputerClassic computerClassic;

    public LenovoComputerClassicBuilder(String cpu, String arm) {
        computerClassic = new ComputerClassic(cpu, arm);
    }

    @Override
    public void setUsbCount() {
        computerClassic.setUsbCount(4);
    }

    @Override
    public void setKeyboard() {
        computerClassic.setKeyboard("联想键盘");
    }

    @Override
    public void setDisplay() {
        computerClassic.setDisplay("联想显示器");
    }

    @Override
    public ComputerClassic getComputer() {
        return computerClassic;
    }
}
