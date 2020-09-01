package com.chance.basis.socket.udpip;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * <p>
 * 接受方
 * <p>
 *
 * @author chance
 * @since 2020-09-01
 */
public class ReceiveDatagramPacketTest {

    public static void main(String[] args) {

        DatagramSocket datagramSocket = null;

        try {
            datagramSocket = new DatagramSocket(8090);
            byte[] bytes = new byte[1024];
            DatagramPacket datagramPacket = new DatagramPacket(bytes, bytes.length);
            datagramSocket.receive(datagramPacket);
            String str = new String(datagramPacket.getData(), 0, datagramPacket.getLength());
            System.out.println(str);

        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            datagramSocket.close();
        }
    }
}
