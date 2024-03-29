package com.wj.funding.admin.web.config;

import com.wj.funding.admin.web.interceptor.LoginInterceptor;
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
    protected void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/admin/**")
                .excludePathPatterns("/admin/*/login")
                .addPathPatterns("/role/**")
                .addPathPatterns("/menu/**")
                .addPathPatterns("/assign/**");

        super.addInterceptors(registry);
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/reg").setViewName("reg");
        registry.addViewController("/admin/main").setViewName("admin-main");
        registry.addViewController("/admin/to/login").setViewName("admin-login");
        registry.addViewController("/admin/to/add").setViewName("admin-add");
        registry.addViewController("/role/to/page").setViewName("role-page");
        registry.addViewController("/menu/to/page").setViewName("menu-page");
        registry.addViewController("/error").setViewName("system-error");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**")
                .addResourceLocations("classpath:/templates/");
    }
}
