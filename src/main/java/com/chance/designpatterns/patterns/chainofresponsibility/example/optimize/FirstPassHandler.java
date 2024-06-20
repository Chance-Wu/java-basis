package com.chance.designpatterns.patterns.chainofresponsibility.example.optimize;

/**
 * 第一关处理类，继承自AbstractHandler。
 * 该类负责处理第一关的逻辑，并根据得分决定是否需要进一步处理（即调用下一关的处理类）。
 *
 * @author: chance
 * @date: 2024/6/20 10:27
 * @since: 1.0
 */
public class FirstPassHandler extends AbstractHandler {

    /**
     * 模拟第一关的游戏玩法，并返回得分。
     *
     * @return 第一关的得分，固定为80。
     */
    private int play() {
        return 80;
    }

    /**
     * 处理第一关的逻辑。
     * 首先打印提示信息，然后调用play方法获取得分。
     * 如果得分大于等于80，并且存在下一关的处理类，则将处理逻辑委托给下一关的处理类。
     * 否则，直接返回当前关的得分。
     *
     * @return 第一关的得分，或者如果存在下一关则为下一关的处理结果。
     */
    @Override
    public int handle() {
        System.out.println("第一关-->FirstPassHandler");
        int score = play();
        if (score >= 80) {
            //分数>=80 并且存在下一关才进入下一关
            if (this.next != null) {
                return this.next.handle();
            }
        }
        return score;
    }
}
