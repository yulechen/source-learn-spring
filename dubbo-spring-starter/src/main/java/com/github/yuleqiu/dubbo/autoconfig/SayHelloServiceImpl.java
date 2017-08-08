package com.github.yuleqiu.dubbo.autoconfig;

import com.alibaba.dubbo.config.annotation.Service;


@Service
public class SayHelloServiceImpl implements SayHelloService {

    @Override
    public void sayHello() {
        System.out.println("Hello Word");
    }

}
