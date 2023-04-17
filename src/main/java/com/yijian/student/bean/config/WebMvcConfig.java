package com.yijian.student.bean.config;

import com.yijian.student.interceptor.AuthorizationInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;

/*
* 自定义WebMvc拦截器
* */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    @Resource
    private  AuthrizationProperties authrizationProperties;

    @Bean
    public AuthorizationInterceptor authorizationInterceptor()
    {
        return new AuthorizationInterceptor();
    }

    /*
    * 配置拦截器
    * */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authorizationInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns(authrizationProperties.getIgnoreUrls());
    }

    /*
    * 配置允许跨域
    * */

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedHeaders("*")
                .allowCredentials(true)
                .allowedMethods("*")
                .maxAge(3600);
    }

}
