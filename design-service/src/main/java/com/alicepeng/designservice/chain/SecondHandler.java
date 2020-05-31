package com.alicepeng.designservice.chain;

import org.springframework.stereotype.Component;

@Component
public class SecondHandler extends AbstractHandler {

    @Override
    public void process(AbstractHandler request) {
        //本次处理
        System.out.println("second do something!");
        //留给下个人处理
        nextHandle.process(request);
    }

}
