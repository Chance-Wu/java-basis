package com.chance.basis.callback;

import java.util.List;

/**
 * @Description: CallBackInterface
 * @Author: chance
 * @Date: 2020-09-23 11:02
 * @Version 1.0
 */
public interface CallBackInterface<T> {

    T process(List<Object> param);
}
