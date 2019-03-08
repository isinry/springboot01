package com.sinrycool.springboot01.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 跨域配置
 *
 * @author ：Sinry
 * @date ：Created in 2019-03-04 15:52
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    public void addCorsMappings (CorsRegistry registry)
    {
        registry.addMapping("/**");
    }

}
