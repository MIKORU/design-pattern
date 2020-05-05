package com.alicepeng.designservice.observer;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.ApplicationEvent;

import java.util.List;

/**
 * 监听订单事件
 */
public class OrderCreateEvent extends ApplicationEvent {

    //消息列表
    @Getter
    @Setter
    private List<String> contentList;


    public OrderCreateEvent(Object source, List<String> contentList) {
        super(source);
        this.contentList = contentList;
    }


}
