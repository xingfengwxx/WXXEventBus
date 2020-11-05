package com.wangxingxing.libdemo.sp;

/**
 * author : 王星星
 * date : 2020/11/5 14:12
 * email : 1099420259@qq.com
 * description :
 */
public class Client {

    public static void main(String[] args) {
        Subscriber subscriber1 = new Subscriber1();
        Subscriber subscriber2 = new Subscriber2();

        // 注册订阅者
        EventDispatcher.getInstance().register(subscriber1);
        EventDispatcher.getInstance().register(subscriber2);

        // 发布消息
        Publisher publisher = new Publisher();
        publisher.postMsg("我是Publisher！");
    }
}
