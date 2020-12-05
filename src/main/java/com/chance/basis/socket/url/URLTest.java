package com.chance.basis.socket.url;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * <p>
 *
 * <p>
 *
 * @author chance
 * @since 2020-09-01
 */
public class URLTest {

    public static void main(String[] args) {
        InputStream inputStream = null;

        try {
            URL url = new URL("https://www.baidu.com");
            inputStream = url.openStream();
            byte[] bytes = new byte[1024];
            int len;
            while ((len = inputStream.read()) != -1) {
                String string = new String(bytes, 0, len);
                System.out.println(string);
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
