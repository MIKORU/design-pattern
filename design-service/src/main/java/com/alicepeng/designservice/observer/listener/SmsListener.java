package com.alicepeng.designservice.observer.listener;

import com.alicepeng.designservice.observer.OrderCreateEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 短信方法监听器
 */
@Component
public class SmsListener implements ApplicationListener<OrderCreateEvent> {
    @Override
    public void onApplicationEvent(OrderCreateEvent orderCreateEvent) {
        List<String> contentList = orderCreateEvent.getContentList();
        //发送短信
        System.out.println("send sms content: " + contentList.toString());
    }
}
