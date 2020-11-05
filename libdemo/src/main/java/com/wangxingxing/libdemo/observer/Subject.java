package com.wangxingxing.libdemo.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * author : 王星星
 * date : 2020/11/5 14:25
 * email : 1099420259@qq.com
 * description : 目标对象
 */
public class Subject {

    // 持有一个观察者的集合
    private List<Observer> mObservers = new ArrayList<>();

    // 注册观察者
    public void register(Observer observer) {
        mObservers.add(observer);
    }

    // 取消注册
    public void unregister(Observer observer) {
        mObservers.remove(observer);
    }

    // 更新事件通知观察者
    public void update(String msg) {
        System.out.println("Subject 发送消息：" + msg);
        for (Observer observer : mObservers) {
            observer.onEvent(msg);
        }
    }
}
