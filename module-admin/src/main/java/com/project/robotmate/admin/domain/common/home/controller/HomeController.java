package com.project.robotmate.admin.domain.common.home.controller;

import com.project.robotmate.admin.domain.common.home.dto.LoginRequest;
import com.project.robotmate.admin.domain.common.home.service.AdminService;
import com.project.robotmate.admin.global.dto.response.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
@Controller
@RequiredArgsConstructor
public class HomeController {

    private final AdminService adminService;

    @GetMapping("/")
    public String home() {
        return "redirect:/galleries";
    }

    @GetMapping("/login")
    public String viewLoginPage() {
        return "login";
    }

    @GetMapping("/logout")
    public String logout() {
        adminService.logout();
        return "redirect:/login";
    }

    @PostMapping("/login")
    @ResponseBody
    public ResponseEntity<ApiResponse> login(
            @RequestBody LoginRequest request
            ) {
        adminService.login(request);
        return ResponseEntity.ok(ApiResponse.ok());
    }

    @PostMapping("/join")
    @ResponseBody
    public ResponseEntity<ApiResponse> join() {
        LoginRequest request = new LoginRequest("admin", "1234");
        adminService.join(request);
        return ResponseEntity.ok(ApiResponse.ok());
    }
}
