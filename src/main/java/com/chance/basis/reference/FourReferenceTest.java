package com.chance.basis.reference;

import org.junit.Test;

import java.lang.ref.SoftReference;

/**
 * @Description: FourReferenceTest
 * @Author: chance
 * @Date: 2020-09-21 14:35
 * @Version 1.0
 */
public class FourReferenceTest {

    @Test
    public void testSoftReference() {
        Obj obj = new Obj();
        //使用obj
        obj.test();
        //使用完了obj,将它设置为soft引用类型,并且释放强引用
        SoftReference sr = new SoftReference(obj);
        obj = null;

        //下次使用
        if (sr != null) {
            obj = (Obj) sr.get();
            obj.test();
        } else {
            //GC由于低内存,已释放obj,因此需要重新装载
            obj = new Obj();
            obj.test();
            obj = null;
            sr = new SoftReference(obj);
        }
    }

    class Obj {
        public void test() {
            System.out.println("SoftReference test");
        }
    }
}
