package com.chinaway.spring.aop;

import java.lang.annotation.Annotation;
import java.lang.reflect.Proxy;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import com.chinaway.spring.aop.annotation.Log;


public class MethodLoggerAop implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }


    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        Annotation[] annotations = bean.getClass().getAnnotations();
        for (Annotation a : annotations) {
            System.out.println(a.getClass());

        }
        if (bean.getClass().getAnnotation(Log.class) != null) {
            return getProxy(bean);
        }
        return bean;
    }


    private Object getProxy(Object bean) {
        return Proxy.newProxyInstance(MethodLoggerAop.class.getClassLoader(),
            bean.getClass().getInterfaces(), new LoggerInvokeHandler(bean));
    }

}
