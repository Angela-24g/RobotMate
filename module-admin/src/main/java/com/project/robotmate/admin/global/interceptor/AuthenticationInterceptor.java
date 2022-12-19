package com.project.robotmate.admin.global.interceptor;

import com.project.robotmate.admin.global.exception.AuthenticationException;
import com.project.robotmate.domain.admin.AdminRepository;
import com.project.robotmate.domain.entity.Admin;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@Component
@RequiredArgsConstructor
public class AuthenticationInterceptor extends HandlerInterceptorAdapter {

    private final AdminRepository adminRepository;

    private final String REQUEST_USER = "user";
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        Admin admin = adminRepository.findByAdminId("admin")
                .orElseThrow(() -> new AuthenticationException("Unauthorized error"));

        log.info("login User={}", admin);

        request.setAttribute(REQUEST_USER, admin);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        if (!ObjectUtils.isEmpty(modelAndView)) {
            modelAndView.addObject("user", request.getAttribute(REQUEST_USER));
        }
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        super.afterCompletion(request, response, handler, ex);
    }
}
