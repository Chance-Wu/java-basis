package com.chance.designpatterns.patterns.factory.abstractstore;

/**
 * <p>
 *
 * <p>
 *
 * @author chance
 * @since 2020-09-15
 */
public class JavaVideo extends Video {
    @Override
    public void produce() {
        System.out.println("录制Java课程视频");
    }
}
