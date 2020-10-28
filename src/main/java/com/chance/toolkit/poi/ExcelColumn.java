package com.chance.toolkit.poi;

import java.lang.annotation.*;

/**
 * @Description: 自定义实体类所需要的bean（Excel属性标题、位置等）
 * @Author: chance
 * @Date: 2020-10-20 08:45
 * @Version 1.0
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ExcelColumn {

    /**
     * Excel标题
     *
     * @return
     * @author Lynch
     */
    String value() default "";

    /**
     * Excel从左往右排列位置
     *
     * @return
     * @author Lynch
     */
    int col() default 0;
}
