package com.github.yuleqiu.dubbo.autoconfig;

import org.springframework.beans.factory.annotation.AnnotatedBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;
import org.springframework.core.type.AnnotationMetadata;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.annotation.Service;


public class DubboClassPathScanner extends ClassPathBeanDefinitionScanner {

    public DubboClassPathScanner(BeanDefinitionRegistry registry) {
        super(registry);
    }


    @Override
    protected boolean isCandidateComponent(AnnotatedBeanDefinition beanDefinition) {
        AnnotationMetadata metadata = beanDefinition.getMetadata();
        return metadata.isAnnotated(Service.class.getName())
                || metadata.isAnnotated(Reference.class.getName());
    }

}
