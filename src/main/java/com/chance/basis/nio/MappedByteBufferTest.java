package com.chance.basis.nio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @Description: MappedByteBufferTest
 * @Author: chance
 * @Date: 6/29/21 9:04 AM
 * @Version 1.0
 */
public class MappedByteBufferTest {

    public static void main(String[] args) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile("/Users/chance/Downloads/test/1.txt", "rw");
        // 获取对应的文件通道
        FileChannel channel = randomAccessFile.getChannel();

        /**
         * 参数1：FileChannel.MapMode.READ_WRITE使用的读写模式
         * 参数2：可以直接修改的起始位置
         * 参数3：是映射到内存的大小，即将1.txt的多少个字节映射到内存
         * 可以直接修改的范围是0~5
         */
        MappedByteBuffer mappedByteBuffer = channel.map(FileChannel.MapMode.READ_WRITE, 0, 5);

        mappedByteBuffer.put(0, (byte) 'H');
        mappedByteBuffer.put(3, (byte) '9');

        randomAccessFile.close();
        System.out.println("修改成功~~");
    }
}
