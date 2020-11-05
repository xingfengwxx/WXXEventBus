package com.wangxingxing.libdemo.sp;

import java.util.ArrayList;
import java.util.List;

/**
 * author : 王星星
 * date : 2020/11/5 12:18
 * email : 1099420259@qq.com
 * description : 事件调度中心（中介）
 */
public class EventDispatcher {

    private static EventDispatcher instance;

    // 持有加入进来的订阅者
    private List<Subscriber> mSubscribers;

    public static EventDispatcher getInstance() {
        if (instance == null) {
            synchronized (EventDispatcher.class) {
                if (instance == null) {
                    instance = new EventDispatcher();
                }
            }
        }
        return instance;
    }

    // 主要做一些初始化的操作
    private EventDispatcher() {
        mSubscribers = new ArrayList<>();
    }

    // [1]把订阅者加入进来
    public void register(Subscriber subscriber) {
        mSubscribers.add(subscriber);
    }

    // [2]发送消息
    public void post(String msg) {
        for (Subscriber subscriber : mSubscribers) {
            subscriber.onEvent(msg);
        }
    }

    // [3]取消订阅
    public void unregister(Subscriber subscriber) {
        mSubscribers.remove(subscriber);
    }
}
