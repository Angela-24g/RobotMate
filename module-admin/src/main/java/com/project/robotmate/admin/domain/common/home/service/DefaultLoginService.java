package com.project.robotmate.admin.domain.common.home.service;

import com.project.robotmate.admin.domain.common.home.dto.AdminDto;
import com.project.robotmate.admin.domain.common.home.dto.LoginRequest;
import com.project.robotmate.domain.entity.admin.repository.AdminRepository;
import com.project.robotmate.domain.entity.admin.Admin;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class DefaultLoginService implements AdminService, UserDetailsService {

    private final AdminRepository adminRepository;
    private final PasswordEncoder passwordEncoder;
    private final HttpSession httpSession;

    private final String AUTH_SESSION_NAME = "user";

    @Transactional
   // @Override
    public void login(LoginRequest request) {
        Admin admin = adminRepository.findByAdminId(request.getAdminId())
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 유저입니다."));

        if (!passwordEncoder.matches(request.getPassword(), admin.getPassword())) {
            throw new IllegalArgumentException("올바르지 않은 비밀번호입니다.");
        }

        httpSession.setAttribute(AUTH_SESSION_NAME, new AdminDto(admin));
    }

    @Transactional
    @Override
    public void join(LoginRequest request) {

        Optional<Admin> findAdmin = adminRepository.findByAdminId(request.getAdminId());

        if (findAdmin.isPresent()) {
            throw new IllegalArgumentException("사용할 수 없는 계정입니다.");
        }

        Admin admin = Admin.builder()
                .adminId(request.getAdminId())
                .password(passwordEncoder.encode(request.getPassword()))
                .name("admin")
                .build();

        adminRepository.save(admin);
    }

 //   @Override
    public void logout() {
        httpSession.removeAttribute(AUTH_SESSION_NAME);
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Admin admin = adminRepository.findByAdminId(username)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 유저입니다."));
        return new com.project.robotmate.admin.domain.admin.security.AdminDetail(admin);
    }
}
