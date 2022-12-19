package com.project.robotmate.admin.global.interceptor;

import com.project.robotmate.admin.global.exception.AuthenticationException;
import com.project.robotmate.domain.entity.Admin;
import org.springframework.core.MethodParameter;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpServletRequest;

public class AuthenticationArgumentResolver implements HandlerMethodArgumentResolver {

    private final String REQUEST_USER = "user";

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.getParameterType().equals(Admin.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {

        HttpServletRequest request = (HttpServletRequest) webRequest.getNativeRequest();

        Admin user = (Admin) request.getAttribute(REQUEST_USER);

        if (ObjectUtils.isEmpty(user)) {
            throw new AuthenticationException("인증 실패");
        }

        return user;
    }
}
