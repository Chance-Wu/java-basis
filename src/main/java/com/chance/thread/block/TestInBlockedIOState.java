package com.chance.thread.block;

import com.alibaba.fastjson.util.IOUtils;
import sun.nio.ch.IOUtil;

import java.util.Scanner;

import static org.junit.Assert.assertThat;

/**
 * @Description: 测试I/O阻塞时线程的状态
 * @Author: chance
 * @Date: 5/7/21 3:10 PM
 * @Version 1.0
 */
public class TestInBlockedIOState {

    public static void main(String[] args) throws InterruptedException {
        Scanner in = new Scanner(System.in);
        // 创建一个名为“输入输出”的线程t
        Thread t = new Thread(() -> {
            try {
                // 命令行中的阻塞读
                String input = in.nextLine();
                // 网络阻塞同理
                //socket.accept();
                System.out.println(input);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                IOUtils.close(in);
            }
        }, "输入输出"); // 线程的名字

        // 启动
        t.start();

        // 确保run已经得到执行
        Thread.sleep(100);

        // 状态为RUNNABLE
        System.out.println(t.getState());
    }
}
