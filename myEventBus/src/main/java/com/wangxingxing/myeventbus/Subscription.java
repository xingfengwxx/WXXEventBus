package com.wangxingxing.myeventbus;

/**
 * author : 王星星
 * date : 2020/11/5 15:59
 * email : 1099420259@qq.com
 * description : 对订阅类和它的某一个订阅方法的相关信息的二次封装
 */
public class Subscription {

    final Object subscriber;
    final SubscriberMethod subscriberMethod;

    public Subscription(Object subscriber, SubscriberMethod subscriberMethod) {
        this.subscriber = subscriber;
        this.subscriberMethod = subscriberMethod;
    }
}
