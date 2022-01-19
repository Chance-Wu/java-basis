package com.chance.toolkit.utils;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.concurrent.FutureCallback;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.nio.client.CloseableHttpAsyncClient;
import org.apache.http.impl.nio.client.HttpAsyncClients;

import java.util.concurrent.CountDownLatch;

/**
 * @Description: AsyncHttpClientUtil
 * @Author: chance
 * @Date: 8/9/21 4:31 PM
 * @Version 1.0
 */
public class AsyncHttpClientUtil {

    /**
     * --发送post 异步调用
     *
     * @param url
     * @param jsonObj
     * @return
     */
    public static void postAsyncByJSONobj(String url, String jsonObj) {
        CloseableHttpAsyncClient httpclient = HttpAsyncClients.createDefault();
        httpclient.start();

        final CountDownLatch latch = new CountDownLatch(1);
        final HttpPost post = new HttpPost(url);

        StringEntity params = new StringEntity(jsonObj, "utf-8");
        params.setContentType("application/json");
        params.setContentEncoding("UTF-8");
        post.setEntity(params);

        httpclient.execute(post, new FutureCallback<HttpResponse>() {

            @Override
            public void completed(final HttpResponse response) {
                latch.countDown();
                //String content = EntityUtils.toString(response.getEntity(), "UTF-8");
                try {
                    latch.await();
                    httpclient.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void failed(final Exception ex) {
                latch.countDown();
                try {
                    latch.await();
                    httpclient.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void cancelled() {
                latch.countDown();
                try {
                    latch.await();
                    httpclient.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        });
    }

    public static void main(String[] args) {

    }
}
