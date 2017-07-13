package com.chinaway.spring.aware;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;


public class BeanFactoryAwareTest implements BeanFactoryAware {

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        DefaultListableBeanFactory f = (DefaultListableBeanFactory) beanFactory;
        String[] beanDefinitionNames = f.getBeanDefinitionNames();
        for (String name : beanDefinitionNames) {
            if (name.equals("gpsCardBindLogService")) {

                System.out.println(name + " " + f.getBean(name).getClass() + " def"
                        + f.getBeanDefinition(name));
            }
        }
        System.out.println(beanFactory);
    }

}
