package com.github.yuleqiu.dubbo.autoconfig;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.context.annotation.Import;

import com.github.yuleqiu.dubbo.autoconfig.DubboAutoConfig.AutoConfiguredMapperScannerRegistrar;


@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@Import({ AutoConfiguredMapperScannerRegistrar.class })
public @interface DubboScan {

    String[] value() default {};
}