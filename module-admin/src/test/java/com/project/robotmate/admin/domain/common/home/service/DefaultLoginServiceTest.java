package com.project.robotmate.admin.domain.common.home.service;

import com.project.robotmate.domain.entity.admin.Admin;
import com.project.robotmate.domain.entity.admin.repository.AdminRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DefaultLoginServiceTest {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    AdminRepository adminRepository;
}