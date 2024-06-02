package com.example.springboot.interceptor;

import com.example.springboot.service.UserService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.resource.ResourceHttpRequestHandler;

/**
 * author Jackasher
 * version 1.0
 * className LoginInterceptor
 * since 1.0
 **/
@Component
public class LoginInterceptor implements HandlerInterceptor {

    private UserService userService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (handler instanceof ResourceHttpRequestHandler) {
            // 如果请求处理程序是 ResourceHttpRequestHandler（用于处理静态资源请求），则直接放行
            return true;
        }
        HttpSession session = request.getSession();
        Object sessionAttribute = session.getAttribute("certify");
        System.out.println(sessionAttribute);

        if (sessionAttribute == null) {
            // 重定向到登录页面
            response.sendRedirect("/login.html");
            return false;
        }

        // 执行相应的逻辑
        return true;
    }
}