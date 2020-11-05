package com.wangxingxing.libdemo.observer;

/**
 * author : 王星星
 * date : 2020/11/5 14:28
 * email : 1099420259@qq.com
 * description :
 */
public class Observer1 implements Observer {
    @Override
    public void onEvent(String msg) {
        System.out.println("Observer1 收到消息：" + msg);
    }
}
