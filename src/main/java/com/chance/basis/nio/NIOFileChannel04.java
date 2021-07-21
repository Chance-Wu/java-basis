package com.chance.basis.nio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

/**
 * @Description: NIOFileChannel04
 * @Author: chance
 * @Date: 6/28/21 4:18 PM
 * @Version 1.0
 */
public class NIOFileChannel04 {

    public static void main(String[] args) throws IOException {

        // 创建输入流
        FileInputStream fileInputStream = new FileInputStream("/Users/chance/Downloads/test/a.jpeg");
        // 创建输出流
        FileOutputStream fileOutputStream = new FileOutputStream("/Users/chance/Downloads/test/copya.jpeg");

        // 获取各个流对应的文件通道
        FileChannel source = fileInputStream.getChannel();
        FileChannel target = fileOutputStream.getChannel();

        // 将字节从给定的source通道中传输到target通道的文件中
        target.transferFrom(source, 0, source.size());

        // 关闭相通道和流
        source.close();
        target.close();
        fileInputStream.close();
        fileOutputStream.close();
    }
}
