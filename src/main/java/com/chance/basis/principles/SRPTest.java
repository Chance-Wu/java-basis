package com.chance.basis.principles;

/**
 * <p>
 * 单一职责原则——SRP
 * <p>
 *
 * @author chance
 * @since 2020-07-17
 */
public class SRPTest {

/**
 * 定义：就一个人类而言，应该仅有一个引起他变化的原因。
 *      即一个类应该只负责一件事情。
 *
 * 如果一个类负责了方法M1，方法M2两个不同的事情，当M1方法发生变化的时候，我们需要修改这个类的M1方法，但是这个时候就有可能导致M2方法不能工作。
 * 这个不是我们期待的，但是由于这种设计却很有可能发生。所以这个时候，我们需要把M1方法，M2方法单独分离成两个类。让每个类只专心处理自己的方法。
 *
 * 优点：
 *  ——降低类的复杂度，一个类只负责一项职责，这样逻辑也简单很多
 *  ——提高类的可读性，和系统的维护性，因为不会有其他奇怪的方法来干扰我们理解这个类的含义 当发生变化的时候，能将变化的影响降到最小，因为只会在这个类中做出修改。
 *
 */
}