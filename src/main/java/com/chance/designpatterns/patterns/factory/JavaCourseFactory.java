package com.chance.designpatterns.patterns.factory;

import com.chance.designpatterns.patterns.factory.abstractstore.Article;
import com.chance.designpatterns.patterns.factory.abstractstore.JavaArticle;
import com.chance.designpatterns.patterns.factory.abstractstore.JavaVideo;
import com.chance.designpatterns.patterns.factory.abstractstore.Video;

/**
 * <p>
 * Java产品工厂
 * <p>
 *
 * @author chance
 * @since 2020-09-16
 */
public class JavaCourseFactory implements CourseFactory {


    @Override
    public Video getVideo() {
        return new JavaVideo();
    }

    @Override
    public Article getArticle() {
        return new JavaArticle();
    }
}
