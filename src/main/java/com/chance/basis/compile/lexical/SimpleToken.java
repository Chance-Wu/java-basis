package com.chance.basis.compile.lexical;

/**
 * <p>
 * Token的一个简单实现。只有类型和文本值两个属性。
 * <p>
 *
 * @author chance
 * @since 2020-04-21
 */
public class SimpleToken implements Token {

    /**
     * Token类型
     */
     TokenType type = null;

    /**
     * 文本值
     */
     String text = null;

    @Override
    public TokenType getType() {
        return type;
    }

    @Override
    public String getText() {
        return text;
    }
}
