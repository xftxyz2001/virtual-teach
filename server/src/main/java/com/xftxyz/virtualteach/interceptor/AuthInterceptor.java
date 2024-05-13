package com.xftxyz.virtualteach.interceptor;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.xftxyz.virtualteach.config.Env;
import com.xftxyz.virtualteach.helper.JwtHelper;
import com.xftxyz.virtualteach.result.Result;
import com.xftxyz.virtualteach.result.ResultEnum;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.HandlerInterceptor;

/**
 * 登录拦截器
 */
@RequiredArgsConstructor
public class AuthInterceptor implements HandlerInterceptor {

    private final ObjectMapper objectMapper;

    @SuppressWarnings("deprecation")
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        // 如果请求方式为OPTIONS
        if (HttpMethod.OPTIONS.matches(request.getMethod())) {
            return true;
        }

        // 获取token
        String token = request.getHeader(HttpHeaders.AUTHORIZATION);
        // 尝试从token中获取用户信息
        Long userId = JwtHelper.parseToken(token);
        // 获取失败，token无效
        if (userId == null) {
            // 返回未登录信息

            response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
            response.getWriter().write(objectMapper.writeValueAsString(
                    Result.failed(ResultEnum.NOT_LOGIN.getCode(), ResultEnum.NOT_LOGIN.getMessage())));
            return false;
        }

        // 将用户信息放入request中
        request.setAttribute(Env.USER_ID, userId);
        return true;
    }
}