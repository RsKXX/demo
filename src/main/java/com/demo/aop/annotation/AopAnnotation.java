package com.demo.aop.annotation;

import java.lang.annotation.*;

/**
 * @Author RuanShaoKang
 * @since 2021/8/9 14:02
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface AopAnnotation {
    String value() default "";
}
