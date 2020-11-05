package com.wangxingxing.libdemo.sp;

/**
 * author : 王星星
 * date : 2020/11/5 12:05
 * email : 1099420259@qq.com
 * description : 订阅者接口
 */
public interface Subscriber {

    // 处理事件的方法
    void onEvent(String msg);
}
