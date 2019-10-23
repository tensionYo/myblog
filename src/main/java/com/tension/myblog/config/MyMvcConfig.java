package com.tension.myblog.config;

import com.tension.myblog.Interceptor.LoginInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration
public class MyMvcConfig extends WebMvcConfigurationSupport {
    /*@Override
    public void addViewControllers(ViewControllerRegistry registry){
        //springmvc扩展功能
        //浏览器发送   请求来到
        System.out.println("addViewControllers()执行了...");
        *//*registry.addViewController("/index").setViewName("index");
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/index.html").setViewName("index");*//*
    }*/



    //springboot2.0以后配置该类路径都要重写
    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry){
        System.out.println("addResourceHandlers()执行了...");
        registry.addResourceHandler("/**")
                .addResourceLocations("classpath:/")
                //.addResourceLocations("classpath:/asserts/**")
                .addResourceLocations("classpath:/static/**")
                .addResourceLocations("classpath:/webjars/")
                .addResourceLocations("classpath:/templates/error/")
                .addResourceLocations("classpath:/templates/**");
         registry.addResourceHandler("/webjars/**")
                 .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }
    //注册拦截器
    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        //springmvc对静态资源css和js会拦截，springboot已经做好了静态资源映射
        //莫不是在吃屁
        //拦截 排除了excludePathPatterns内的这些外的所有请求
        registry.addInterceptor(new LoginInterceptor()).
                addPathPatterns("/admin/**").
                excludePathPatterns("/admin","/admin/login");
    }
}
