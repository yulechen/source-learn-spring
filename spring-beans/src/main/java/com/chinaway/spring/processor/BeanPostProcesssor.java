package com.chinaway.spring.processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import com.chinaway.spring.bean.SomeService;


public class BeanPostProcesssor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("postProcessBeforeInitialization" + bean);
        Object returnBean = bean;
        System.out.println(beanName);
        if (bean.getClass() == SomeService.class) {
            bean = new SomeService();
        }
        System.out.println(bean);
        return bean;
    }


    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("postProcessAfterInitialization" + bean);
        Object returnBean = bean;
        System.out.println(beanName);
        if (bean.getClass() == SomeService.class) {
            bean = new SomeService();
        }
        System.out.println(bean);
        return bean;
    }

}
