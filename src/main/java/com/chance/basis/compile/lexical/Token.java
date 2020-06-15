package com.chance.basis.compile.lexical;

/**
 * <p>
 * 简单的Token，有类型和文本值两个属性
 * <p>
 *
 * @author chance
 * @since 2020-04-21
 */
public interface Token {

    /**
     * Token的类型
     */
    TokenType getType();

    /**
     * Token的文本值
     */
    String getText();
}