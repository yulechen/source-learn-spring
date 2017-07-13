package com.chinaway.spring.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.TypeVariable;


public class LoggerInvokeHandler implements InvocationHandler {

    private Object oriObject;


    public LoggerInvokeHandler(Object oriObject) {
        super();
        this.oriObject = oriObject;
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // showMethodInfo(method, args);
        System.out.println("methoname" + method.getName());
        return method.invoke(oriObject, args);
    }


    private void showMethodInfo(Method method, Object[] args) {
        TypeVariable<Method>[] typeParameters = method.getTypeParameters();
        for (TypeVariable<Method> type : typeParameters) {
            System.out.println(type.getName());
        }
        for (Object obj : args) {
            System.out.println(obj);
        }
    }

}
