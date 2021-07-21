package com.chance.basis.nio;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @Description: NIOFileChannel02
 * @Author: chance
 * @Date: 6/28/21 1:52 PM
 * @Version 1.0
 */
public class NIOFileChannel02 {

    public static void main(String[] args) throws IOException {

        // 创建文件的输入流
        File file = new File("/Users/chance/Downloads/test/file01.txt");
        FileInputStream fileInputStream = new FileInputStream(file);

        // 获取FileChannel——>实际类型是FileChannelImpl
        FileChannel fileChannel = fileInputStream.getChannel();

        // 创建缓冲区
        ByteBuffer byteBuffer = ByteBuffer.allocate((int) file.length());

        // 将通道的数据读入到缓冲区
        fileChannel.read(byteBuffer);

        // 将缓冲区的字节数据转成String
        String str = new String(byteBuffer.array());
        System.out.println(str);
    }
}
