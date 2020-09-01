package com.chance.basis.socket;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * <p>
 *
 * <p>
 *
 * @author chance
 * @since 2020-09-01
 */
public class InetAddressTest {

    public static void main(String[] args) {
        try {
            //根据域名创建 InetAddress对象
//            InetAddress inetAddress = InetAddress.getByName("www.baidu.com");
            //根据IP地址创建 InetAddress对象
            InetAddress inetAddress = InetAddress.getByName("36.152.44.96");

            //获取本机的IP
            InetAddress inet1 = InetAddress.getLocalHost();

            System.out.println(inetAddress.getHostName());
            System.out.println(inet1);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
