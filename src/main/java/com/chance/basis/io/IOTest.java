package com.chance.basis.io;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

/**
 * @Description: IOTest
 * @Author: chance
 * @Date: 2020-10-13 21:03
 * @Version 1.0
 */
public class IOTest {

    @Test
    public void testByteArray() {
        byte[] buf = "hello".getBytes();
        ByteArrayInputStream in = null;
        try {
            in = new ByteArrayInputStream(buf);

            //缓冲容器
            byte[] flush = new byte[20];
            //接收长度
            int len;
            while ((len = in.read(flush)) != -1) {
                String str = new String(flush, 0, len);
                System.out.print(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (in != null) {
                    // 释放资源
                    in.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}