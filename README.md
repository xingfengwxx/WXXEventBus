# EventBus源码分析及手写实现

- EventBus的主要用途
  - 简化了Android中事件的传递
  - 常用于Activity, Fragment， Service等组件之间的通信
- 组件通信的传统实现方式
  - Intent，Broadcast，Handler，回调接口
- EventBus的优势
  - 轻量级框架，使用起来非常简单
  - 可以灵活切换线程
  - 使代码简洁优雅，逻辑更清晰
  - 执行效率高
- EventBus的使用步骤
  - 注册订阅register()，取消注册unregister()
  - 实现订阅方法，通过@Subscribe注解
  - 通过post()方法来发送消息，以传入的参数类型来区分事件
- EventBus核心流程：register(), post(), unregister()
- register流程
    ![register流程.png](http://ww1.sinaimg.cn/large/0073bao7gy1gke5r2scu0j30hz0iijs9.jpg)
- post流程
    ![post流程.png](http://ww1.sinaimg.cn/large/0073bao7gy1gke5oxq9q3j305o0didg1.jpg)
- register()解析
  - 主要分为两个步骤：查找，订阅
  - 查找：
    - 从METHOD_CACHE中获取SubscriberMethod方法的集合
    - 如果缓存中有，就直接返回
    - 缓存中没有，通过反射遍历当前订阅类的所有方法，再筛选出符合条件的订阅方法
  - 订阅：
    - 遍历已经获取到的List<SubscriberMethod>
    - 把SubscriberMethod和对应的订阅类进行再次封装成Subscription
    - 把这个Subscription对象添加到集合中，把这个集合跟当前事件类型以key-value形式保存到subscriptionsByEventType这个Map中去
    - 把当前的订阅者对象和他的所有订阅方法参数的类型集合，以key-value形式保存到typesBySubscriber这个Map中去
  - 【熟悉几个关键的类和变量】
    - SubscriberMethod:  对订阅方法的相关信息的封装类(Method,ThreadMode,eventType等属性)
    - Subscription: 对订阅类对象和他的一个SubscriberMethod的二次封装类
    - eventType: 事件类型的class对象
    - subscriptionsByEventType: HashMap
      - key：事件类型对象(eventType)
      - value：对应的订阅方法的Subscription集合
    - typesBySubscriber: HashMap
      - key：当前订阅者对象(subscriber)
      - value：当前订阅类中的所有订阅方法的参数类型的集合

   - 手写实现EventBus
     - 1.基本的事件传递
     - 2.我们要进行线程切换