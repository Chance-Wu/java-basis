package com.chance.designpatterns.patterns.factory;

import com.chance.designpatterns.patterns.factory.abstractstore.Article;
import com.chance.designpatterns.patterns.factory.abstractstore.Video;

/**
 * <p>
 * 抽象工厂
 * <p>
 *
 * @author chance
 * @since 2020-09-16
 */
public interface CourseFactory {

    Video getVideo();

    Article getArticle();
}
