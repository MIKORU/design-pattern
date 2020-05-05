package com.alicepeng.designservice.observer.Impl;

import com.alicepeng.designservice.observer.OrderCreateEvent;
import com.alicepeng.designservice.observer.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private ApplicationEventPublisher publisher;

    @Override
    public void saveOrder() {
        //save order
        System.out.println(">>>>>>>>>>> save order success!");
        //发送通知
        //TODO 若是要更新成别的通知？需要更改此处代码。
        //System.out.println(">>>>>>>>>>> send sms: save order success!");

        //改成观察者模式后---发布事件
        List<String> contentList = new ArrayList<>(6);
        contentList.add("ID2137819461");
        String name = "WX9900";
        OrderCreateEvent event = new OrderCreateEvent(this, contentList);
        //发布事件
        publisher.publishEvent(event);

    }
}
