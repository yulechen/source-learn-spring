package com.github.yulechen.demo.resource;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;

import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.util.ResourceUtils;

public class MainClassPathResource {

    
    
    public static void main(String[] args) throws IOException {
//        String localtion= "root.properties"; // not /root.propertes
//        String localtionError= "/root.properties"; 
//        String localtionPackage= "com/github/yulechen/demo/resource/child.properties"; // not /root.propertes
//        classLoaderResource(localtion); // 
//        classLoaderResource(localtionPackage); // 
        
        springResourceLoaderTest(); // 支持ANT 匹配
    }

    
    public  static void  classLoaderResource(String path) throws IOException{
        URL resource = MainClassPathResource.class.getClassLoader(). getResource(path);
        System.out.println("single:"+resource.toString()+" "+ResourceUtils.getFile(resource).exists());
        Enumeration<URL> resources = MainClassPathResource.class.getClassLoader().getResources(path); // 自定义classloader 可以返回多个
        while(resources.hasMoreElements()){
            URL nextElement = resources.nextElement();
            System.out.println("mulit:"+nextElement.toString()+" "+ResourceUtils.getFile(nextElement).exists());
        }
        
        System.out.println("-------------------------------");
    }
    
    
   public static void springResourceLoaderTest () throws IOException{
       PathMatchingResourcePatternResolver rr = new PathMatchingResourcePatternResolver();
//       Resource resource = rr.getResource("classpath:com/github/yulechen/demo/*/child.properties");
//       System.out.println(resource.exists());
       String sinlge = "classpath:com/github/yulechen/demo/*/child.properties";
       String mulit = "classpath*:com/github/yulechen/demo/resource/child.properties";
       Resource[] resources = rr.getResources(mulit);
       for(Resource r :resources){
           System.out.println(r);
       }
   } 
}
