package com.chance.basis.exception;

/**
 * @Description: LostMessage
 * @Author: chance
 * @Date: 2020-09-24 09:53
 * @Version 1.0
 */
public class LostMessage {
    void f() throws VeryImportantException {
        throw new VeryImportantException();
    }

    void dispose() throws HoHumException {
        throw new HoHumException();
    }

    public static void main(String[] args) throws Exception {
        LostMessage lm = new LostMessage();
        try {
            lm.f();
        } finally {
            lm.dispose();
        }
    }
}
