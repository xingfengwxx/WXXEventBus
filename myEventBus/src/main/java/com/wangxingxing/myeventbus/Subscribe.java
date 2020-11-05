package com.wangxingxing.myeventbus;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * author : 王星星
 * date : 2020/11/5 15:58
 * email : 1099420259@qq.com
 * description : 订阅事件注解
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Subscribe {

    ThreadMode threadMode() default ThreadMode.POSTING;
}
