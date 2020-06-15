package com.chance.basis.compile.lexical;

/**
 * <p>
 * 一个Token流.由lexer生成。Parser可以从中获取Token。
 * <p>
 *
 * @author chance
 * @since 2020-04-21
 */
public interface TokenReader {
    /**
     * 返回Token流中下一个Token，并从流中取出。 如果流已经为空，返回null;
     */
    Token read();

    /**
     * 返回Token流中下一个Token，但不从流中取出。 如果流已经为空，返回null;
     */
    Token peek();

    /**
     * Token流回退一步。恢复原来的Token。
     */
    void unread();

    /**
     * 获取Token流当前的读取位置。
     */
    int getPosition();

    /**
     * 设置Token流当前的读取位置
     */
    void setPosition(int position);
}
