package com.project.robotmate.admin.global.aop;

import com.project.robotmate.admin.domain.admin.security.AdminDetail;
import com.project.robotmate.admin.global.exception.AuthenticationException;
import com.project.robotmate.domain.entity.admin.Admin;
import com.project.robotmate.domain.entity.admin.repository.AdminRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.core.MethodParameter;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import java.security.Principal;

@Component
@RequiredArgsConstructor
public class CustomUserArgumentResolver implements HandlerMethodArgumentResolver {

    private final AdminRepository adminRepository;

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.getParameterType().equals(Admin.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer,
                                  NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        Principal principal = webRequest.getUserPrincipal();
        if (principal instanceof UsernamePasswordAuthenticationToken) {
            AdminDetail userDetails = (AdminDetail) ((UsernamePasswordAuthenticationToken) principal).getPrincipal();

            return adminRepository.findByAdminId(userDetails.getLoginId())
                    .orElseThrow(() -> new AuthenticationException("Unauthorized error"));
        }
        return null;
    }
}
