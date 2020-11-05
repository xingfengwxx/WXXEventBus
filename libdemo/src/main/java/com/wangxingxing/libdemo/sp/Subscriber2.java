package com.wangxingxing.libdemo.sp;

/**
 * author : 王星星
 * date : 2020/11/5 12:08
 * email : 1099420259@qq.com
 * description :
 */
public class Subscriber2 implements Subscriber {
    @Override
    public void onEvent(String msg) {
        System.out.println("我是Subscriber2：" + msg);
    }
}
