package com.alicepeng.designservice.chain;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class ExecuteHandle {

    @Bean
    public CommandLineRunner commandLineRunner(FirstHandler first,
                                               SecondHandler second,
                                               ThirdHandler third
                                               ){
        return clr-> first.setNextStep(second).setNextStep(third);
    }

}
