package com.chance.thread.create;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;

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
    public String call() {
        return "结束";
    }

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();

        // 创建一个线程池，对线程进行管理和分配
        ExecutorService executor = Executors.newFixedThreadPool(6);
        // 用Future来接受返回值
        List<Future<String>> results = new ArrayList<>();
        results.add(executor.submit(new CallableTest()));
        results.add(executor.submit(new CallableTest()));
        results.add(executor.submit(new CallableTest()));
        // 关闭线程池，释放资源
        executor.shutdown();

        // 最后，用主线程的容器装载其他线程的返回值
        for (int i = 0; i < results.size(); i++) {
            try {
                System.out.println(results.get(i).get());
                list.add(results.get(i).get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
    }
}
