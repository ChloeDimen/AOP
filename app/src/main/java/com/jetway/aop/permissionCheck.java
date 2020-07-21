package com.jetway.aop;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 文件名：com.jetway.aop
 * 描    述：
 * 作    者：Dimen
 * 时    间：2020/7/21
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface permissionCheck {
    String value();
}
