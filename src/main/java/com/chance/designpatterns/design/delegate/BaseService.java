package com.chance.designpatterns.design.delegate;

/**
 * <p>
 * 抽象服务类接口，提供执行任务的方法
 * <p>
 *
 * @author chance
 * @since 2020-09-11
 */
public interface BaseService {

    /**
     * 执行命令的方法
     */
    void execute();
}
