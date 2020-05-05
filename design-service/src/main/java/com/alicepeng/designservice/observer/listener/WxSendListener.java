package com.alicepeng.designservice.observer.listener;

import com.alicepeng.designservice.observer.OrderCreateEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.SmartApplicationListener;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 微信方法监听器
 */
@Component
public class WxSendListener implements SmartApplicationListener {

    @Override
    public boolean supportsEventType(Class<? extends ApplicationEvent> aClass) {
        return aClass == OrderCreateEvent.class;
    }

    @Override
    public void onApplicationEvent(ApplicationEvent applicationEvent) {
        OrderCreateEvent orderCreateEvent = (OrderCreateEvent) applicationEvent;
        List<String> contentList = orderCreateEvent.getContentList();
        //发送微信
        System.out.println("send wx content: " + contentList.toString());
    }

    //次序
    @Override
    public int getOrder() {
        return 2;
    }
}
