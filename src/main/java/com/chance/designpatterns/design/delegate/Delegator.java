package com.chance.designpatterns.design.delegate;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * 委派者类，负责委派，分发任务，最后提交执行的结果
 * <p>
 *
 * @author chance
 * @since 2020-09-11
 */
public class Delegator {

    /**
     * 用一个容器存放不同的子任务对应的执行对象
     */
    private Map<String, BaseService> map = new HashMap<>();

    /**
     * 任务的委派，分发
     *
     * @param msg
     * @return
     */
    private BaseService delegate(String msg) {
        map.put("code1", new Code1ServiceImpl());
        map.put("code2", new Code2ServiceImpl());
        if ("code1".equals(msg)) {
            return map.get(msg);
        } else if ("code2".equals(msg)) {
            return map.get(msg);
        }
        System.out.println("Error in delegation task！");
        return null;
    }

    /**
     * 任务具体的执行
     *
     * @param msg
     */
    public void execute(String msg) {
        BaseService service = this.delegate(msg);
        if (service != null) {
            // 调执行方法
            service.execute();
        }
    }
}
