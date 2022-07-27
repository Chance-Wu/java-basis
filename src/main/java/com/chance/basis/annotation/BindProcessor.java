package com.chance.basis.annotation;

import com.google.j2objc.annotations.AutoreleasePool;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.element.TypeElement;
import java.util.Set;

/**
 * @author: chance
 * @date: 2022/7/8 14:02
 * @since: 1.0
 */
public class BindProcessor  extends AbstractProcessor {

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        return false;
    }
}
