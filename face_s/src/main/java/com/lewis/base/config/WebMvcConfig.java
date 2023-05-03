package com.lewis.base.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;


//@Configuration
public class WebMvcConfig extends WebMvcConfigurationSupport {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        /*registry.addResourceHandler("/**")
                .addResourceLocations("classpath:/static/")
                .addResourceLocations("classpath:/resources/");
        registry.addResourceHandler("/templates/**")
                .addResourceLocations("classpath:/resources/templates/");*/
        registry.addResourceHandler("/res/**").addResourceLocations("file:C:\\\\Users\\Administrator\\Desktop\\res\\");
        super.addResourceHandlers(registry);
    }
}


