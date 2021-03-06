package com.hxh.cart.interceptor;


import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Component
public class SpringBootConfig extends WebMvcConfigurerAdapter {


    @Override
    public void addInterceptors(InterceptorRegistry registry) {


        registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/order/toOrder");
    }
}
