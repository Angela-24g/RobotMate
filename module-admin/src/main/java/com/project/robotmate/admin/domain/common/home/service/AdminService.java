package com.project.robotmate.admin.domain.common.home.service;

import com.project.robotmate.admin.domain.common.home.dto.LoginRequest;

public interface AdminService {
    void login(LoginRequest request);

    void join(LoginRequest request);

    void logout();
}
