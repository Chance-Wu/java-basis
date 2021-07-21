package com.chance.basis.nio;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @Description: NIOFileChannel01
 * @Author: chance
 * @Date: 6/28/21 10:22 AM
 * @Version 1.0
 */
public class NIOFileChannel01 {

    public static void main(String[] args) throws IOException {
        String str = "hello,chance";

        // 创建一个输出流
        FileOutputStream fileOutputStream = new FileOutputStream("/Users/chance/Downloads/test/file01.txt");

        // 通过输出流获取对应的FileChannel
        FileChannel fileChannel = fileOutputStream.getChannel();

        // 创建一个缓冲区
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

        // 将str放入byteBuffer
        byteBuffer.put(str.getBytes());

        // 对byteBuffer进行flip
        byteBuffer.flip();
        // 将byteBuffer数据写入到fileChannel
        fileChannel.write(byteBuffer);
        fileOutputStream.close();
    }
}
