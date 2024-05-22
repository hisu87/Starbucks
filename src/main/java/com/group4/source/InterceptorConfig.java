package com.group4.source;

import com.group4.source.interceptor.AuthorizeInterceptor;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
    @Autowired
    AuthorizeInterceptor authorizeInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry interceptorRegistry) {
        interceptorRegistry.addInterceptor(authorizeInterceptor)
                .addPathPatterns("/home/cart/**","/home/cart","/home/order",
                        "/account/profilecard","/account/changePassword",
                        "/home/admin","/home/admin/**")
                .excludePathPatterns("/home/index","/home/product-detail",
                        "/account/login");
    }
}
