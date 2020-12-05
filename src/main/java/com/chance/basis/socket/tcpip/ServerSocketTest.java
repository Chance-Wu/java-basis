package com.chance.basis.socket.tcpip;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * <p>
 *
 * <p>
 *
 * @author chance
 * @since 2020-09-01
 */
public class ServerSocketTest {

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket socket = null;
        InputStream acceptIs = null;
        OutputStream os = null;
        try {

            //1.创建一个ServerSocket的对象
            serverSocket = new ServerSocket(9898);
            //2.调用其accept()方法，返回一个Socket的对象
            socket = serverSocket.accept();
            //3.将从客户端发送来的信息保存到本地
            acceptIs = socket.getInputStream();
            byte[] b = new byte[1024];
            int len;
            while ((len = acceptIs.read(b)) != -1) {
                String str = new String(b, 0, len);
                System.out.println(str);
            }

            //4.发送"接收成功"的信息反馈给客户端
            os = socket.getOutputStream();
            os.write("你发送的信息我已接收成功！".getBytes());

        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                acceptIs.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
