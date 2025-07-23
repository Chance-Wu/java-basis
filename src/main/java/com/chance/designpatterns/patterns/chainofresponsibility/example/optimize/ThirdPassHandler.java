package com.chance.designpatterns.patterns.chainofresponsibility.example.optimize;

/**
 * 第三关处理类，继承自AbstractHandler，实现处理逻辑。
 * 在这个类中，处理逻辑是给定分数95，并根据分数决定是否继续传递处理请求。
 *
 * @author chance
 * @date 2024/6/20 10:27
 * @since 1.0
 */
public class ThirdPassHandler extends AbstractHandler {

    /**
     * 执行第三关的玩乐操作，返回玩乐得分。
     *
     * @return 第三关的得分，这里固定返回95。
     */
    private int play() {
        return 95;
    }

    /**
     * 处理请求的方法。
     * 如果当前关卡的分数大于等于95，并且存在下一个处理者，则将请求传递给下一个处理者。
     * 否则，返回当前关卡的分数。
     *
     * @return 处理结果，即关卡的分数。
     */
    @Override
    public int handle() {
        System.out.println("第三关-->ThirdPassHandler");
        int score = play();
        if (score >= 95) {
            //分数>=95 并且存在下一关才进入下一关
            if (this.next != null) {
                return this.next.handle();
            }
        }
        return score;
    }
}
