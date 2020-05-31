package com.alicepeng.designservice.chain;

import org.springframework.stereotype.Component;

@Component
public class FirstHandler extends AbstractHandler {

    @Override
    public void process(AbstractHandler request) {
        //本次处理
        System.out.println("first do something!");
        //移交下一个人处理
        nextHandle.process(request);
    }
}
