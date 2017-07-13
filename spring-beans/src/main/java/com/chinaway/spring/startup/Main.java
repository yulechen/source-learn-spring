package com.chinaway.spring.startup;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.chinaway.spring.bean.ISomeService;


public class Main {

    public static void main(String[] args) {
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("spring-test.xml");
        ISomeService bean = (ISomeService) context.getBean("someservice");
        System.out.println(bean);
        bean.showName("zhang san ni hao");
    }

}
