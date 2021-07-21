package com.chance.basis.nio.selector;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

/**
 * @Description: SelectorServer
 * @Author: chance
 * @Date: 6/30/21 2:44 PM
 * @Version 1.0
 */
public class SelectorServer {

    private static final int PORT = 7000;
    private static ByteBuffer buffer = ByteBuffer.allocate(1024);

    public static void main(String[] args) {
        try {
            ServerSocketChannel ssc = ServerSocketChannel.open();
            ssc.bind(new InetSocketAddress(PORT));
            ssc.configureBlocking(false);
            //1.register()
            Selector selector = Selector.open();
            ssc.register(selector, SelectionKey.OP_ACCEPT);
            System.out.println("REGISTER CHANNEL , CHANNEL NUMBER IS:" + selector.keys().size());

            while (true) {
                //2.select()
                if (selector.select(1000) == 0) {
                    System.out.println("服务器等待了1秒，无连接");
                    continue;
                }
                //3.轮询SelectionKey
                Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
                while (iterator.hasNext()) {
                    SelectionKey key = iterator.next();
                    //如果满足Acceptable条件，则必定是一个ServerSocketChannel
                    if (key.isAcceptable()) {
                        ServerSocketChannel sscTemp = (ServerSocketChannel) key.channel();
                        SocketChannel socketChannel = sscTemp.accept();
                        socketChannel.configureBlocking(false);
                        //将SocketChannel注册到Selector上，关注操作为READ
                        socketChannel.register(selector, SelectionKey.OP_READ);
                        System.out.println("REGISTER CHANNEL , CHANNEL NUMBER IS:" + selector.keys().size());
                    }
                    //如果满足Readable条件，则必定是一个SocketChannel
                    if (key.isReadable()) {
                        //读取通道中的数据
                        SocketChannel channel = (SocketChannel) key.channel();
                        readFromChannel(channel);
                    }
                    //4.remove SelectionKey
                    iterator.remove();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void readFromChannel(SocketChannel channel) {
        buffer.clear();
        try {
            while (channel.read(buffer) > 0) {
                buffer.flip();
                byte[] bytes = new byte[buffer.remaining()];
                buffer.get(bytes);
                System.out.println("READ FROM CLIENT:" + new String(bytes));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}