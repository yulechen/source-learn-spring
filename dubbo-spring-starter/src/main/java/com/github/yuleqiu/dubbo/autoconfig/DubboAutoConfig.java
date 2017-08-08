package com.github.yuleqiu.dubbo.autoconfig;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.type.AnnotationMetadata;

import com.alibaba.dubbo.config.spring.AnnotationBean;
import com.github.yuleqiu.App;


@Configuration
public class DubboAutoConfig {

    @Bean
    public AnnotationBean getDubboBean() {
        AnnotationBean annotationBean = new AnnotationBean();
        annotationBean.setPackage(App.class.getPackage().getName());
        return annotationBean;
    }

    public static class AutoConfiguredMapperScannerRegistrar implements BeanFactoryAware,
            ImportBeanDefinitionRegistrar, ResourceLoaderAware {

        private BeanFactory beanFactory;

        private ResourceLoader resourceLoader;


        @Override
        public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata,
                BeanDefinitionRegistry registry) {
            System.out.println(importingClassMetadata.getAnnotationAttributes(DubboScan.class.getName()));
        }


        @Override
        public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
            this.beanFactory = beanFactory;
        }


        @Override
        public void setResourceLoader(ResourceLoader resourceLoader) {
            this.resourceLoader = resourceLoader;
        }
    }

}
