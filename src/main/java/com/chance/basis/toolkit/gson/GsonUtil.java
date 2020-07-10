package com.chance.basis.toolkit.gson;

import com.google.gson.Gson;

/**
 * <p>
 * 单例Gson对象
 * <p>
 *
 * @author chance
 * @since 2020-07-10
 */
public class GsonUtil {

    private static class GsonHolder {
        private static final Gson INSTANCE = new Gson();
    }

    /**
     * 获取Gson实例，由于Gson是线程安全的，这里共同使用同一个Gson实例
     */
    public static Gson getGsonInstance() {
        return GsonHolder.INSTANCE;
    }
}
