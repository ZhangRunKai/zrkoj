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
                        allowedOriginPatterns("*").
                        allowedMethods("*"). //允许任何方法（post、get等）
                        allowedHeaders("*"). //允许任何请求头
                        allowCredentials(true). //带上cookie信息
                        exposedHeaders(HttpHeaders.SET_COOKIE).maxAge(3600L); //maxAge(3600)表明在3600秒内，不需要再发送预检验请求，可以缓存该结果
            }
        };
    }
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        //注册TestInterceptor拦截器
//        InterceptorRegistration registration = registry.addInterceptor(new RequestIntercept());
//        registration.addPathPatterns("/**");                      //所有路径都被拦截
//        registration.excludePathPatterns(                         //添加不拦截路径
//                "/user/login",
//                "/user/register",
//                "/admin/login",
//                "/admin/register"
//        );
//    }

//    @Override
//    public void addCorsMappings(CorsRegistry registry) {
//        registry.addMapping("/**")    //添加映射路径，“/**”表示对所有的路径实行全局跨域访问权限的设置
//                .allowedOrigins("http://localhost:8080/")    //开放哪些ip、端口、域名的访问权限
//                .allowCredentials(true)  //是否允许发送Cookie信息
//                .allowedMethods("GET","POST", "PUT", "DELETE")     //开放哪些Http方法，允许跨域访问
//                .allowedHeaders("*")     //允许HTTP请求中的携带哪些Header信息
//                .exposedHeaders("*");   //暴露哪些头部信息（因为跨域访问默认不能获取全部头部信息）
//    }
}
