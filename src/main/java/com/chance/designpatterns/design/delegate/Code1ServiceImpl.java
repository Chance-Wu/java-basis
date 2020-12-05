package com.chance.designpatterns.design.delegate;

/**
 * <p>
 * 具体服务实现类，执行相应的任务
 * <p>
 *
 * @author chance
 * @since 2020-09-11
 */
public class Code1ServiceImpl implements BaseService {
    @Override
    public void execute() {
        System.out.println("execute coding task1");
    }
}
