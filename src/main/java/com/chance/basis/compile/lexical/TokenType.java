package com.chance.basis.compile.lexical;

/**
 * <p>
 * Token类型
 * <p>
 *
 * @author chance
 * @since 2020-04-21
 */
public enum TokenType {
    Plus,   // +
    Minus,  // -
    Star,   // *
    Slash,  // /

    GE,     // >=
    GT,     // >
    EQ,     // ==
    LE,     // <=
    LT,     // <

    SemiColon, // ;
    LeftParen, // (
    RightParen,// )

    Assignment,// =

    If,
    Else,

    Int,

    Identifier,     //标识符
    IntLiteral,     //整型字面量
    StringLiteral   //字符串字面量
}
