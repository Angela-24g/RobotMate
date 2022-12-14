package com.project.robotmate.admin.global.aop;

import com.project.robotmate.admin.global.exception.AuthenticationException;
import com.project.robotmate.domain.entity.admin.repository.AdminRepository;
import com.project.robotmate.domain.entity.admin.Admin;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Slf4j
@Aspect
//@Component
public class AuthAop {

    private final AdminRepository adminRepository;

    public AuthAop(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    @Around("execution(* com.project.robotmate.admin..*Controller.*(..))")
    public Object authMethod(ProceedingJoinPoint joinPoint) throws Throwable {
        Object[] args = joinPoint.getArgs();

        Admin admin = adminRepository.findByAdminId("admin")
                .orElseThrow(() -> new AuthenticationException("Unauthorized error"));

        for (int i = 0 ; i < args.length ; i++) {
            if (args[i] instanceof Admin) {
                args[i] = admin;
            }
        }

        return joinPoint.proceed(args);
    }


}
