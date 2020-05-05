package com.alicepeng.designservice.factory;

import com.alicepeng.designservice.factory.strategy.PayStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 支付渠道策略工厂-spring工厂
 */
@Component
public class ChannelFactory {

    @Autowired
    private Map<String, PayStrategy> strategyMap = new ConcurrentHashMap<>(6);

    /**
     * 根据名称获取对应策略
     * @param name
     * @return
     */
    public PayStrategy getStrategy(String name) {
        if (!StringUtils.isEmpty(name) && !CollectionUtils.isEmpty(strategyMap)) {
            return strategyMap.get(name);
        }

        return null;
    }


}
