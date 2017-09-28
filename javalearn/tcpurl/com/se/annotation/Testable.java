package com.se.annotation;

import java.lang.annotation.*;

/**
 * Created by lty on 2017-9-19.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented
public @interface Testable {

    String name() default "jackie";

    int age() default 20;
}
