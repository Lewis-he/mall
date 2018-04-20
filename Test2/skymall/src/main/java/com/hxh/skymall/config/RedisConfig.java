package com.hxh.skymall.config;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableCaching
public class RedisConfig  {

    @Bean(name = "redis")
    public Map<String,String> getMapRedis(){
        Map<String, String> stringStringHashMap = new HashMap<>();

        System.out.println("第一次");
        return stringStringHashMap;
    }
}
