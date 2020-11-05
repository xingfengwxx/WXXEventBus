package com.wangxingxing.libdemo.sp;

/**
 * author : 王星星
 * date : 2020/11/5 12:16
 * email : 1099420259@qq.com
 * description : 发布者
 */
public class Publisher {

    // 发布消息
    public void postMsg(String msg) {
        System.out.println("Publisher: " + msg);
        // 把消息告诉事件中心
        EventDispatcher.getInstance().post(msg);
    }
}
