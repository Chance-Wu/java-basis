package com.chance.basis.nio;

import java.nio.IntBuffer;

/**
 * @Description: BufferTest
 * @Author: chance
 * @Date: 6/25/21 3:10 PM
 * @Version 1.0
 */
public class BufferTest {

    public static void main(String[] args) {

        // 创建一个 Buffer，大小为5，可以存放5个int类型数据
        IntBuffer intBuffer = IntBuffer.allocate(5);
        // 向 buffer 存放数据
        for (int i = 0; i < intBuffer.capacity(); i++) {
            intBuffer.put(i * 2);
        }

        // 读写切换
        intBuffer.flip();

        // 指定开始读的标记位
        intBuffer.position(1);
        // 指定结束标记位
        intBuffer.limit(3);

        while (intBuffer.hasRemaining()) {
            // 从 buffer 读取数据
            System.out.println(intBuffer.get());
        }

    }
}
