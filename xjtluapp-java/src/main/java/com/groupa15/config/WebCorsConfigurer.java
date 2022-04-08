package com.groupa15.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Arrays;
import java.util.List;

/**
 * @author Zirui Zhou
 * @date 2022/3/31
 */

@Configuration
public class WebCorsConfigurer implements WebMvcConfigurer{
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
            .allowedOriginPatterns("*")
            .allowedMethods("GET", "HEAD", "POST", "PUT", "DELETE", "OPTIONS")
            .allowedHeaders("Content-Type", "Access-Control-Allow-Headers", "Authorization", "X-Requested-With")
            .exposedHeaders("Access-Control-Allow-Headers", "Authorization", "x-xsrf-token",
                    "Access-Control-Allow-Headers", "Origin", "Accept", "X-Requested-With",
                    "Content-Type", "Access-Control-Request-Method", "Access-Control-Request-Headers")
            .allowCredentials(true);
       }
//    private CorsConfiguration corsConfig() {
//        CorsConfiguration corsConfiguration = new CorsConfiguration();
//        corsConfiguration.addAllowedOrigin("*");
//        corsConfiguration.addAllowedHeader("Content-Type, Access-Control-Allow-Headers, Authorization, X-Requested-With");
//        corsConfiguration.addAllowedMethod("GET, HEAD, POST, PUT, DELETE, OPTIONS");
//        corsConfiguration.setExposedHeaders(Arrays.asList("Authorization", "Access-Control-Allow-Headers"));
//        corsConfiguration.setAllowCredentials(true);
//        return corsConfiguration;
//    }
//
//    @Bean
//    public CorsFilter corsFilter() {
//        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//        source.registerCorsConfiguration("/**", corsConfig());
//        return new CorsFilter(source);
//    }

}

