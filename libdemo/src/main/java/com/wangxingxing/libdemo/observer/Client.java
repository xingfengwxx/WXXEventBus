package com.wangxingxing.libdemo.observer;

/**
 * author : 王星星
 * date : 2020/11/5 14:29
 * email : 1099420259@qq.com
 * description :
 */
public class Client {

    public static void main(String[] args) {

        Observer observer1 = new Observer1();
        Observer observer2 = new Observer2();

        Subject subject = new Subject();
        subject.register(observer1);
        subject.register(observer2);

        // 目标对象状态更新了
        subject.update("渣渣辉已上线，系兄弟就来砍我");

        subject.unregister(observer1);
        subject.unregister(observer2);
    }
}
