package com.alicepeng.designservice.singleton;

import javafx.beans.property.Property;
import org.springframework.util.StringUtils;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.Objects;
import java.util.Properties;

/**
 * @Auther: alicepeng
 * @Date: 2020/4/27 15:20
 * @Description:
 */
public class Swicth {

    //配置开关
    private boolean isOpen;
    private Properties property;

    //饿汉 加载既实现
    private static Swicth swicth = new Swicth();

    public Swicth getSwicthHungry() {
        return swicth;
    }

    //懒汉 减少初始化加载
    private volatile static Swicth swicthLazy;

    public Swicth getSwitchLazy() {
        if (swicthLazy == null) {
            synchronized (Swicth.class) {
                if (swicthLazy != null) {
                    swicthLazy = new Swicth();
                }
            }
        }
        return swicthLazy;
    }

    /**
     * 静态内部类 初始化不会被加载
     */
    private static class SwitchHolder {
        private static final Swicth instance = new Swicth();
    }

    public static Swicth getInstance() {
        return SwitchHolder.instance;
    }

    //初始化配置，仅读取一次
    private Swicth() {
        property = new Properties();

        InputStream stream = Swicth.class.getClassLoader().getResourceAsStream("application.properties");
        try {
            if (Objects.nonNull(stream)) {
                InputStreamReader reader = new InputStreamReader(stream, "UTF-8");
                property.load(reader);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        String openStr = this.property.getProperty("design.pattern.open");
        if (StringUtils.isEmpty(openStr)) {
            this.isOpen = false;
            return;
        }
        this.isOpen = Boolean.parseBoolean(openStr);
    }

    public Boolean getIsOpen() {
        return this.isOpen;
    }
}
