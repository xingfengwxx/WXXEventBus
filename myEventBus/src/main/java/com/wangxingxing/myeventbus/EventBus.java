package com.wangxingxing.myeventbus;

import android.os.Handler;
import android.os.Looper;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class EventBus {

    private static EventBus instance;

    private static final Map<Class<?>, List<SubscriberMethod>> METHOD_CACHE = new HashMap<>();

    private final Map<Class<?>, CopyOnWriteArrayList<Subscription>> mSubscriptionsByEvent;

    private final Map<Object, List<Class<?>>> mTypesBySubscriber;

    private final ExecutorService mExecutor;

    public static EventBus getInstance() {
        if (instance == null) {
            synchronized (EventBus.class) {
                if (instance == null) {
                    instance = new EventBus();
                }
            }
        }
        return instance;
    }

    private EventBus() {
        mSubscriptionsByEvent = new HashMap<>();
        mTypesBySubscriber = new HashMap<>();
        mExecutor = Executors.newCachedThreadPool();
    }

    // [1]register：查找，注册
    public void register(Object subscriber) {
        // 先查找出所有的符合条件的订阅方法
        Class<?> clazz = subscriber.getClass();

    }

    /**
     * 通过缓存获取已有List<SubscriberMethod>
     *
     * @param clazz
     * @return
     */
    private List<SubscriberMethod> findSubscriberMethods(Class<?> clazz) {
        List<SubscriberMethod> subscriberMethods = METHOD_CACHE.get(clazz);

        if (subscriberMethods != null) {
            return subscriberMethods;
        }

        subscriberMethods = findByReflection(clazz);
        if (!subscriberMethods.isEmpty()) {
            METHOD_CACHE.put(clazz, subscriberMethods);
        }
        return subscriberMethods;
    }

    /**
     * 通过反射去查找所有的订阅方法
     *
     * @param clazz
     * @return
     */
    private List<SubscriberMethod> findByReflection(Class<?> clazz) {
        List<SubscriberMethod> subscriberMethods = new ArrayList<>();

        // 先获取所有的订阅类的方法
        Method[] methods = clazz.getMethods();

        // 进行条件筛选
        for (Method method : methods) {
            int modifiers = method.getModifiers();
            if (modifiers == Modifier.PUBLIC) {
                Class<?>[] paramsList = method.getParameterTypes();
                if (paramsList.length == 1) {
                    Subscribe annotation = method.getAnnotation(Subscribe.class);
                    if (annotation != null) {
                        ThreadMode threadMode = annotation.threadMode();
                        SubscriberMethod subscriberMethod = new SubscriberMethod(method, threadMode, paramsList[0]);
                        subscriberMethods.add(subscriberMethod);
                    }
                }
            }
        }
        return subscriberMethods;
    }

    // [2]进行post传递消息
    public void post(Object event) {
        Class<?> eventType = event.getClass();
        List<Subscription> subscriptions = mSubscriptionsByEvent.get(eventType);
        if (subscriptions != null && !subscriptions.isEmpty()) {
            for (Subscription subscription : subscriptions) {
                postSingleSubscription(subscription, event);
            }
        }
    }

    private void postSingleSubscription(Subscription subscription, Object event) {

        boolean isMainThread = Looper.getMainLooper() == Looper.myLooper();

        ThreadMode threadMode = subscription.subscriberMethod.threadMode;
        switch (threadMode) {
            case POSTING:
                invokeMethod(subscription, event);
                break;
            case MAIN:
            case MAIN_ORDERED:
                if (isMainThread) {
                    invokeMethod(subscription, event);
                } else {
                    Handler handler = new Handler(Looper.getMainLooper());
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            invokeMethod(subscription, event);
                        }
                    });
                }
                break;
            case BACKGROUND:
            case ASYNC:
                if (isMainThread) {
                    Runnable runnable = new Runnable() {
                        @Override
                        public void run() {
                            invokeMethod(subscription, event);
                        }
                    };
                    mExecutor.execute(runnable);
                } else {
                    invokeMethod(subscription, event);
                }
                break;
        }
    }

    private void invokeMethod(Subscription subscription, Object event) {
        try {
            subscription.subscriberMethod.method.invoke(subscription.subscriber, event);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    // [3]取消注册
    public void unregister(Object subscriber) {
        List<Class<?>> types = mTypesBySubscriber.get(subscriber);
        // 遍历所有参数类型集合
        for (Class<?> eventType : types) {
            List<Subscription> subscriptions = mSubscriptionsByEvent.get(eventType);
            int size = subscriptions.size();
            for (int i = 0; i < size; i++) {
                Subscription subscription = subscriptions.get(i);
                if (subscription.subscriber == subscriber) {
                    subscriptions.remove(i);
                    size--;
                    i--;
                }
            }
        }
        mTypesBySubscriber.remove(subscriber);
    }
}

