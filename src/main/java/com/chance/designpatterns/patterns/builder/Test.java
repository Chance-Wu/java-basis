package com.chance.designpatterns.patterns.builder;

import com.chance.designpatterns.patterns.builder.classic.ComputerClassic;
import com.chance.designpatterns.patterns.builder.classic.ComputerClassicDirector;
import com.chance.designpatterns.patterns.builder.classic.MacComputerClassicBuilder;
import com.chance.designpatterns.patterns.builder.simple.Computer;

/**
 * <p>
 *
 * <p>
 *
 * @author chance
 * @since 2020-06-09
 */
public class Test {

    public static void main(String[] args) {
        Computer computer = new Computer.Builder("i5", "8g").build();

        // 经典Builder模式
        // 1.生成director
        // 2.生成一个目标builder
        // 3.使用director组装builder
        ComputerClassicDirector director = new ComputerClassicDirector();
        MacComputerClassicBuilder builder = new MacComputerClassicBuilder("i5处理器", "三星125");
        director.makeComputerClassic(builder);
        ComputerClassic macComputer = builder.getComputer();

    }
}
