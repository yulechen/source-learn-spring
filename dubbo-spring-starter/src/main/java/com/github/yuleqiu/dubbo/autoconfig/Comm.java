package com.github.yuleqiu.dubbo.autoconfig;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import com.alibaba.dubbo.config.annotation.Reference;


@Component
public class Comm implements InitializingBean {

    @Reference
    SayHelloService sayHelloService;


    @Override
    public void afterPropertiesSet() throws Exception {
        sayHelloService.sayHello();
    }

}
