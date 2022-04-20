package com.groupa15.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author Zirui Zhou
 * @date 2022/4/6
 */

@Configuration
public class WebResourceConfigurer implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //和页面有关的静态目录都放在项目的static目录下
        // TODO(Zirui): Modify the path of resource
        String resourcePath = Paths.get("resource").toString();
        registry.addResourceHandler("/static/**").addResourceLocations("file:./resource/");
    }

}
