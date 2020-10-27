package com.shi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.Charset;

/**
 * @author DaTou
 * @Description
 * @Date 2020/9/17
 **/
@Configuration
public class Config {


    @Bean
    public RestTemplate restTemplate(){
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate;
    }

    @Bean("threadPoolTaskExecutor")
    public ThreadPoolTaskExecutor threadPoolTaskExecutor(){
        ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
        threadPoolTaskExecutor.setMaxPoolSize(10);
        threadPoolTaskExecutor.setCorePoolSize(10);
        return threadPoolTaskExecutor;
    }
}
