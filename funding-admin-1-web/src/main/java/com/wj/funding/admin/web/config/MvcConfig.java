package com.wj.funding.admin.web.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

/**
 * Created by white_wolf on 2019/10/16.
 *
 * @author thebestwj
 */
@Configuration
public class MvcConfig extends WebMvcConfigurationSupport {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**")
                .addResourceLocations("classpath:/templates/");
    }
}
