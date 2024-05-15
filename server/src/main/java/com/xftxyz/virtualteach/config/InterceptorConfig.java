package com.xftxyz.virtualteach.config;

import com.xftxyz.virtualteach.interceptor.AuthInterceptor;
import com.xftxyz.virtualteach.interceptor.LoggingInterceptor;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 拦截器配置
 */
@Configuration
@RequiredArgsConstructor
@Import({AuthInterceptor.class, LoggingInterceptor.class})
public class InterceptorConfig implements WebMvcConfigurer {

    private final AuthInterceptor authInterceptor;
    private final LoggingInterceptor loggingInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loggingInterceptor).addPathPatterns("/**");

        // 排除登录接口/login、swagger接口
        registry.addInterceptor(authInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns("/api/user/login", "/swagger-ui/**", "/v3/api-docs/**");

    }
}