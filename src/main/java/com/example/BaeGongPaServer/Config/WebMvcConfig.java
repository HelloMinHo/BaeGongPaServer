package com.example.BaeGongPaServer.Config;

import lombok.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        WebMvcConfigurer.super.addResourceHandlers(registry);

        //registry.addResourceHandler("/img/**").addResourceLocations("file:///workspace/assets/img/");
        registry.addResourceHandler("/img/**").addResourceLocations("file:///D:/img/");

    }


}
