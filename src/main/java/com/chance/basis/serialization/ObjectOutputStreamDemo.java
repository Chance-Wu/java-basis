package com.chance.basis.serialization;

import com.chance.basis.entity.Car;

import java.io.*;

/**
 * <p>
 *
 * <p>
 *
 * @author chance
 * @since 2020-02-05
 */
public class ObjectOutputStreamDemo {

    public static void main(String[] args) throws Exception {
        //序列化后生成指定文件路径
        File file = new File("/Users/chance/Desktop" + File.separator + "person.ser");
        ObjectOutputStream oos = null;
        //装饰流（流）
        oos = new ObjectOutputStream(new FileOutputStream(file));

        //实例化类（包含对不可序列化的Car对象的引用，导致整个序列化失败）
        Person per = new Person("张三", 30, new Car());
        //把类对象序列化
        oos.writeObject(per);
        oos.close();
    }
}
