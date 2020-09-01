package com.chance.basis.socket.tcpip;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
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
public class SocketTest {

    public static void main(String[] args) {
        Socket socket = null;
        OutputStream os = null;

        try {
            //1.创建Socket的对象
            socket = new Socket(InetAddress.getByName("127.0.0.1"), 9898);
            //2.写消息发送给服务端
            os = socket.getOutputStream();
            os.write("client".getBytes());

            socket.shutdownOutput();

            //3.接收来自于服务端的信息
            InputStream is = socket.getInputStream();
            byte[] b1 = new byte[1024];
            int len1;
            while ((len1 = is.read(b1)) != -1) {
                String str = new String(b1, 0, len1);
                System.out.print(str);
            }
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
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
