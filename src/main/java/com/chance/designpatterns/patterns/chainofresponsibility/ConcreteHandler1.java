package com.chance.designpatterns.patterns.chainofresponsibility;

/**
 * 具体处理者1，实现了Handler接口。
 *
 * @author: chance
 * @date: 2024/6/12 10:24
 * @since: 1.0
 */
public class ConcreteHandler1 implements TransHandler {

    private TransHandler next;

    @Override
    public void setNext(TransHandler next) {
        this.next = next; // 建立责任链
    }

    /**
     * 在处理请求前，检查this.next是否为null，避免空指针异常。
     * 同时，增加基本的参数校验来提高代码的安全性。
     *
     * @param request 请求字符串
     */
    @Override
    public void handleRequest(String request) {
        if (request == null || request.isEmpty()) {
            System.out.println("Invalid request.");
            return;
        }
        if (request.equals("one")) {
            // 执行当前处理者的处理逻辑
            System.out.println("ConcreteHandler1 processing request: " + request);
        } else {
            // 如果存在下一个处理者，则将请求传递给它
            if (next != null) {
                try {
                    next.handleRequest(request);
                } catch (Exception e) {
                    System.out.println("Error occurred while processing request by next handler. " + e.getMessage());
                }
            } else {
                System.out.println("Request processing ended, no next handler found.");
            }
        }
    }
}