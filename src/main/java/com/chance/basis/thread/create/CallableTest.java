package com.chance.basis.thread.create;

import java.util.concurrent.Callable;

/**
 * <p>
 * 创建Runnable并重写run()方法或者Callable对象并重写call()方法
 * <p>
 *
 * @author chance
 * @since 2020-01-20
 */
public class CallableTest implements Callable<String> {

    /**
     * 任务
     */
    @Override
    public String call() throws Exception {
        try {
            String a = "return String";
            return a;
        } catch (Exception e) {
            e.printStackTrace();
            return "exception";
        }
    }
}
