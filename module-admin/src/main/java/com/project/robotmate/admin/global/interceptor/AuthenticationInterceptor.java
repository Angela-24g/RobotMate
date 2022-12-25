package com.project.robotmate.admin.global.interceptor;

import com.project.robotmate.admin.domain.common.home.dto.AdminDto;
import com.project.robotmate.admin.global.exception.AuthenticationException;
import com.project.robotmate.domain.admin.AdminRepository;
import com.project.robotmate.domain.entity.Admin;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.Optional;

import static com.project.robotmate.admin.global.util.CommonUtil.isAjax;


@Slf4j
@Component
@RequiredArgsConstructor
public class AuthenticationInterceptor extends HandlerInterceptorAdapter {

    private final AdminRepository adminRepository;

    private final String REQUEST_USER = "user";
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();

        AdminDto adminDto = (AdminDto) session.getAttribute(REQUEST_USER);

        if (ObjectUtils.isEmpty(adminDto)) {
            if (isAjax(request)) {
                throw new AuthenticationException("Unauthorized error");
            } else {
                response.sendRedirect("/login?redirectUri=" + request.getRequestURI());
            }
        }

        Optional<Admin> findAdmin = adminRepository.findById(adminDto.getId());

        if (findAdmin.isEmpty()) {
            if (isAjax(request)) {
                throw new AuthenticationException("Unauthorized error");
            } else {
                response.sendRedirect("/login?redirectUri=" + request.getRequestURI());
            }
        }

        request.setAttribute(REQUEST_USER, findAdmin.orElse(null));

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        if (!isAjax(request) && !ObjectUtils.isEmpty(modelAndView)) {
            Object user = request.getAttribute(REQUEST_USER);
            modelAndView.addObject("user", user);
        }
    }
}
