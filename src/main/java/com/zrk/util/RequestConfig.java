package com.zrk.util;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author zhang run kai
 * @version 1.0
 * @date 2021/3/5 23:11
 */

@Configuration
public class RequestConfig implements WebMvcConfigurer {
    @Bean
    public WebMvcConfigurer corsConfigurer()
    {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").
                        exposedHeaders("authorization").
                        allowedOriginPatterns("*").
                        allowedMethods("*"). //允许任何方法（post、get等）
                        allowedHeaders("*"). //允许任何请求头
                        allowCredentials(false). //带上cookie信息
                        exposedHeaders(HttpHeaders.SET_COOKIE).maxAge(3600L); //maxAge(3600)表明在3600秒内，不需要再发送预检验请求，可以缓存该结果
            }
        };
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        InterceptorRegistration interceptorRegistration = registry.addInterceptor(new RequestIntercept());
        interceptorRegistration.addPathPatterns("/**");
        interceptorRegistration.excludePathPatterns("/user/login","/user/register","/error");
    }
}
