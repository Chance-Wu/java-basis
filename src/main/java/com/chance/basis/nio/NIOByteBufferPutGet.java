package com.chance.basis.nio;

import java.nio.ByteBuffer;

/**
 * @Description: NIOByteBufferPutGet
 * @Author: chance
 * @Date: 6/29/21 8:26 AM
 * @Version 1.0
 */
public class NIOByteBufferPutGet {

    public static void main(String[] args) {

        // 创建一个Buffer
        ByteBuffer buffer = ByteBuffer.allocate(64);

        // 类型化方式放入数据
        buffer.putInt(100);
        buffer.putLong(9);
        buffer.putChar('吴');
        buffer.putShort((short)4);

        //取出
        buffer.flip();

        System.out.println(buffer.getInt());
        System.out.println(buffer.getLong());
        System.out.println(buffer.getChar());
        System.out.println(buffer.getShort());
    }
}
