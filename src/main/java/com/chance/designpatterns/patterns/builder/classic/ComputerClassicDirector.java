package com.chance.designpatterns.patterns.builder.classic;

/**
 * 指导者类
 *
 * @author: chance
 * @date: 2022/9/1 20:56
 * @since: 1.0
 */
public class ComputerClassicDirector {

    public void makeComputerClassic(ComputerClassicBuilder builder) {
        builder.setDisplay();
        builder.setUsbCount();
        builder.setKeyboard();
    }
}
