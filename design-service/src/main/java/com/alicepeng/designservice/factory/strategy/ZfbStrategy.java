package com.alicepeng.designservice.factory.strategy;

import org.springframework.stereotype.Component;

/**
 * zfb支付渠道
 */
@Component("zfb")
public class ZfbStrategy implements PayStrategy {
    @Override
    public void pay(int moneny) {
        System.out.println("zfb pay moneny: " + moneny);
    }
}
