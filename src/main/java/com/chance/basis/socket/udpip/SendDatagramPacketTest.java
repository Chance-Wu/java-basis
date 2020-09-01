package com.chance.basis.socket.udpip;

import java.io.IOException;
import java.net.*;

/**
 * <p>
 * 发送端
 * <p>
 *
 * @author chance
 * @since 2020-09-01
 */
public class SendDatagramPacketTest {

    public static void main(String[] args) {

        DatagramSocket datagramSocket = null;

        try {
            datagramSocket = new DatagramSocket();
            byte[] bytes = "hello, chance".getBytes();
            DatagramPacket datagramPacket = new DatagramPacket(bytes,bytes.length, InetAddress.getByName("127.0.0.1"),8090);
            datagramSocket.send(datagramPacket);

        } catch (SocketException e) {
            e.printStackTrace();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            datagramSocket.close();
        }
    }
}
