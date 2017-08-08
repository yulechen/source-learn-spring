package com.github.yuleqiu;

import java.util.List;
import java.util.concurrent.locks.LockSupport;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.support.SpringFactoriesLoader;

import com.github.yuleqiu.dubbo.autoconfig.DubboScan;


@SpringBootApplication
@DubboScan("com.github.yuleqiu")
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
        List<String> loadFactoryNames =
                SpringFactoriesLoader.loadFactoryNames(EnableAutoConfiguration.class,
                    App.class.getClassLoader());
        for (String f : loadFactoryNames) {
            System.out.println(f);
        }

        LockSupport.park();
    }
}
