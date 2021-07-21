package com.chance.basis.nio;

import java.nio.ByteBuffer;

/**
 * @Description: ReadOnlyBuffer
 * @Author: chance
 * @Date: 6/29/21 8:52 AM
 * @Version 1.0
 */
public class ReadOnlyBuffer {

    public static void main(String[] args) {

        ByteBuffer buffer = ByteBuffer.allocate(64);
        for (int i = 0; i < 64; i++) {
            buffer.put((byte) i);
        }

        // 读取
        buffer.flip();

        // 得到一个只读的Buffer
        ByteBuffer readOnlyBuffer = buffer.asReadOnlyBuffer();
        System.out.println(readOnlyBuffer.getClass());

        // 读取
        while (readOnlyBuffer.hasRemaining()) {
            System.out.println(readOnlyBuffer.get());
        }

        // 会抛出异常ReadOnlyBufferException
        readOnlyBuffer.put((byte)100);
    }
}
