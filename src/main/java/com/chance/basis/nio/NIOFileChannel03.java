package com.chance.basis.nio;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @Description: NIOFileChannel03
 * @Author: chance
 * @Date: 6/28/21 2:05 PM
 * @Version 1.0
 */
public class NIOFileChannel03 {

    public static void main(String[] args) throws IOException {
        // 创建文件输入流
        FileInputStream fileInputStream = new FileInputStream("/Users/chance/Downloads/test/file01.txt");
        FileChannel fileChannel = fileInputStream.getChannel();

        // 创建文件输出流
        FileOutputStream fileOutputStream = new FileOutputStream("/Users/chance/Downloads/test/copyfile01.txt");
        FileChannel fileChannel1 = fileOutputStream.getChannel();

        // 创建缓冲区
        ByteBuffer byteBuffer = ByteBuffer.allocate(512);

        while (true) {

            // 清空buffer
            byteBuffer.clear();
            // 将通道的数据读入到缓冲区
            int read = fileChannel.read(byteBuffer);
            if (read == -1) { // 表示读完
                break;
            }
            // 切换读写模式
            byteBuffer.flip();
            // 将缓冲区的数据写入到fileChannel1——>copyfile01.txt
            fileChannel1.write(byteBuffer);
        }

        // 关闭相关的流
        fileInputStream.close();
        fileOutputStream.close();
    }
}
