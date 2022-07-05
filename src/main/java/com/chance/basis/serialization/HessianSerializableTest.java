package com.chance.basis.serialization;

import com.caucho.hessian.io.Hessian2Input;
import com.caucho.hessian.io.Hessian2Output;
import com.caucho.hessian.io.HessianInput;

import java.io.*;

/**
 * @author: chance
 * @date: 2022/7/5 22:18
 * @since: 1.0
 */
public class HessianSerializableTest {

    public static void main(String[] args) throws IOException {
        FlyPig flyPig = new FlyPig();
        flyPig.setColor("black");
        flyPig.setName("naruto");
        flyPig.setCar("0000");

        // 把flyPig对象序列化为byte数组
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        Hessian2Output output = new Hessian2Output(bos);
        output.writeObject(flyPig);
        output.flushBuffer();
        byte[] data = bos.toByteArray();
        bos.close();

        // 把刚才序列化出来的byte数组转化为student对象
        ByteArrayInputStream bis = new ByteArrayInputStream(data);
        Hessian2Input input = new Hessian2Input(bis);
        FlyPig deFlyPig = (FlyPig) input.readObject();
        input.close();

        System.out.println(deFlyPig);
    }
}
