package com.alicepeng.designservice.factory.strategy;

import org.springframework.stereotype.Component;

/**
 * 微信支付
 */
@Component("wx")
public class WxPayStrategy implements PayStrategy {
    @Override
    public void pay(int moneny) {
        System.out.println("wx pay money: " + moneny);
    }
}
