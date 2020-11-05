package com.wangxingxing.myeventbus;

import java.lang.reflect.Method;

/**
 * author : 王星星
 * date : 2020/11/5 15:59
 * email : 1099420259@qq.com
 * description : 保存订阅方法相关信息的封装类
 */
public class SubscriberMethod {

    final Method method;
    final ThreadMode threadMode;
    final Class<?> eventType;

    public SubscriberMethod(Method method, ThreadMode threadMode, Class<?> eventType) {
        this.method = method;
        this.threadMode = threadMode;
        this.eventType = eventType;
    }

    public Method getMethod() {
        return method;
    }

    public ThreadMode getThreadMode() {
        return threadMode;
    }

    public Class<?> getEventType() {
        return eventType;
    }
}
