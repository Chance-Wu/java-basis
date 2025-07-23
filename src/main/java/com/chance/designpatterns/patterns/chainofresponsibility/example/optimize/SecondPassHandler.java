package com.chance.designpatterns.patterns.chainofresponsibility.example.optimize;

/**
 * 第二关处理类，继承自AbstractHandler，实现处理流程的具体逻辑。
 * 在这个类中，主要负责处理第二关的业务逻辑，并根据处理结果决定是否需要将请求传递给下一个处理器。
 *
 * @author chance
 * @date 2024/6/20 10:27
 * @since 1.0
 */
public class SecondPassHandler extends AbstractHandler {

    /**
     * 执行第二关的玩乐操作，返回玩乐得分。
     *
     * @return 第二关的得分，这里固定返回90。
     */
    private int play() {
        return 90;
    }

    /**
     * 处理第二关的逻辑。
     * 调用play方法获取得分。
     * 如果得分大于等于90，并且存在下一关的处理类，则将处理逻辑委托给下一关的处理类。
     * 否则，直接返回当前关的得分。
     *
     * @return 第二关的得分，或者如果存在下一关则为下一关的处理结果。
     */
    @Override
    public int handle() {
        System.out.println("第二关-->SecondPassHandler");
        int score = play();
        if (score >= 90) {
            //分数>=90 并且存在下一关才进入下一关
            if (this.next != null) {
                return this.next.handle();
            }
        }
        return score;
    }
}
