package com.alicepeng.designservice.singleton;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Constructor;
import java.util.concurrent.TimeUnit;

/**
 * 单例模式
 * 常用于基础的配置类，工厂类，多用于读取使用的全局单例
 * 常见实现：懒汉式（双重检测），饿汉式，内部静态类，枚举单例，spring框架bean实现（缓存+双重检测）
 * 反射可破坏除枚举以外的单例模式
 * @Auther: alicepeng
 * @Date: 2020/4/26 16:20
 * @Description:
 */
@Slf4j
public class SingletonDemo {
    public static void main(String[] args) throws Exception {
        new Thread(() -> {
            Swicth instance = Swicth.getInstance();
            Swicth instance2 = Swicth.getInstance();

            try {
                Constructor<Swicth> constructors = Swicth.class.getDeclaredConstructor();
                constructors.setAccessible(true);
                Swicth instance3 = constructors.newInstance();

                Env code = Env.INSTANT;
                Env code2 = Env.INSTANT;


                String name = Thread.currentThread().getName();
                System.out.println(name + " instance == instance2? result: " + (instance == instance2));
                System.out.println(name + " instance: " + instance.toString() + " isOpen: " + instance.getIsOpen());
                System.out.println(name + " instance3: " + instance3.toString() + " isOpen: " + instance3.getIsOpen());
                System.out.println(name + " code == code2? result: " + (code==code2));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "test1").start();
        new Thread(() -> {
            Swicth instance = Swicth.getInstance();
            Env code = Env.INSTANT;
            code.handlerPrint("????");

            String name = Thread.currentThread().getName();
            System.out.println(name + " instance: " + instance.toString() + " isOpen: " + instance.getIsOpen());
            System.out.println(name + " code: " + code.toString());

        }, "test2").start();

        TimeUnit.MINUTES.sleep(1);
    }

    /**
     * 枚举型单例 防反射破坏 effective-java
     */
    @AllArgsConstructor
    @Getter
    enum Env {
        INSTANT,
        ;

        public void handlerPrint(String str) {
            System.out.println("print str: " + str);
        }
    }
}
