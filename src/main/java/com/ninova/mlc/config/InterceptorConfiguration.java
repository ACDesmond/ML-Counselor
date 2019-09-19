package com.ninova.mlc.config;

import com.ninova.mlc.interceptor.SessionInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author ycf
 * @date 2019/7/26
 */
@Configuration
public class InterceptorConfiguration implements WebMvcConfigurer {
    public final static String SESSION_KEY = "user";

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        /*开发时只用注释下面这一句*/
       registry.addInterceptor(new SessionInterceptor()).excludePathPatterns("/login", "/index", "/signUp", "/register","/CompareVerfCode" ,"/SendVerfCode","/error","/monthHistory", "/**/*.css", "/**/*.js", "/**/*.png", "/**/*.gif", "/**/*.jpg", "/**/*.jpeg", "/font/**").addPathPatterns("/**");
    }

}
