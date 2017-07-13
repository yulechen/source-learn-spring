package com.chinaway.spring.bean;

import java.lang.annotation.Annotation;

import com.chinaway.spring.aop.annotation.Log;


@Log
public class SomeService implements ISomeService {

    /* (non-Javadoc)
     * @see com.chinaway.spring.bean.ISomeService#showName(java.lang.String)
     */
    @Override
    public void showName(String name) {
        System.out.println(name);
    }


    public static void main(String[] args) {
        Annotation[] annotations = SomeService.class.getAnnotations();
        for (Annotation a : annotations) {
            System.out.println(a.getClass());

        }
    }
}
